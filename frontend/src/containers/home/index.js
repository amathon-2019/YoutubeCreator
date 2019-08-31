import React, { useState } from 'react'
import useInput from '../../hooks/use-input'
import SearchInput from '../../components/search-input'
import ChannelInfoCard from '../../components/channel-info-card'
import { getVideoId } from '../../utils/video-id'
import { getVideoInfo } from '../../apis/video-info'

const Home = () => {
  const inputEvent = useInput('')
  const [iframSrc, setIframSrc] = useState('')
  const [cardVisible, setCardVisible] = useState(false)
  const [videoInfo, setVideoInfo] = useState()
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
  return (
    <div>
      <main role="main" className="px-3">
        <h1>Youtube Creator를 위한 댓글 추첨 사이트</h1>
        <SearchInput inputEvent={inputEvent} handleClick={handleClick} handlePress={handlePress} />
      </main>
      {cardVisible && <ChannelInfoCard iframSrc={iframSrc} videoInfo={videoInfo} />}
    </div>
  )
}

export default Home
