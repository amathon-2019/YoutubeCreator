import React, { useEffect } from 'react'
import { useSelector } from 'react-redux'
import VideoCard from '../../components/video-card'
import { getVideoId } from '../../utils/video-id'

const Mypage = ({ history }) => {
  const { login } = useSelector(state => state.login)
  useEffect(() => {
    if (!login) {
      history.push('/')
    }
  }, [login])
  const urlList = [
    'https://www.youtube.com/watch?v=m32r3atf1rU',
    'https://www.youtube.com/watch?v=h7LU7_9XMUs',
  ]

  return (
    <div>
      {urlList.map(videoSrc => {
        const videoId = getVideoId(videoSrc)
        console.log(videoId)
        return <VideoCard key={videoId} videoId={videoId} />
      })}
    </div>
  )
}

export default Mypage
