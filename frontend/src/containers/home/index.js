import React, { useState } from 'react'
import useInput from '../../hooks/use-input'
import SearchInput from '../../components/search-input'
import VideoInfoCard from '../../components/video-info-card'
import DrawList from '../../components/draw-list'
import { getVideoId } from '../../utils/video-id'
import { getVideoInfo } from '../../apis/video-info'
import { getVideoComment } from '../../apis/video-comment'
import { getThumbnail } from '../../apis/thumbnail'

const Home = () => {
  const inputEvent = useInput('')
  const [iframSrc, setIframSrc] = useState('')
  const [cardVisible, setCardVisible] = useState(false)
  const [videoInfo, setVideoInfo] = useState()
  const [drawList, setDrawList] = useState([])

  const handleClick = () => {
    const videoId = getVideoId(inputEvent.value)
    videoId ? something(videoId) : alert('invalid url')
  }
  const handlePress = ({ key }) => {
    if (key === 'Enter') {
      const videoId = getVideoId(inputEvent.value)
      videoId ? something(videoId) : alert('invalid url')
    }
  }
  async function something(videoId) {
    setIframSrc(videoId)
    setCardVisible(true)
    const videoInfo = await getVideoInfo(videoId)
    if (!videoInfo) return null
    if (videoInfo.items.length === 0) return null
    console.log(videoInfo.items[0])
    setVideoInfo(videoInfo.items[0].statistics)
  }
  const getComments = async () => {
    const response = await getVideoComment(iframSrc, 3)
    if (response) {
      const nextDrawList = await response.map(item => {
        return {
          name: item.authorName,
          // thumbnail: getThumbnail(item.authorId).then(data => data),
        }
      })
      await console.log(nextDrawList)
      setDrawList(nextDrawList)
    }
  }
  return (
    <div>
      <main role="main" className="px-3">
        <h1 className="mb-5">Youtube Creator를 위한 댓글 추첨 사이트</h1>
        <SearchInput inputEvent={inputEvent} handleClick={handleClick} handlePress={handlePress} />
      </main>
      {cardVisible && (
        <VideoInfoCard videoId={iframSrc} videoInfo={videoInfo} onClick={getComments} />
      )}
      {drawList.length !== 0 && <DrawList drawList={drawList} />}
    </div>
  )
}

export default Home
