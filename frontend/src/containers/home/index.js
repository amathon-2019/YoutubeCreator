import React, { useState } from 'react'
import useInput from '../../hooks/use-input'
import SearchInput from '../../components/search-input'

const Home = () => {
  const inputEvent = useInput('')
  const [iframSrc, setIframSrc] = useState('')
  const handleClick = () => {
    const videoId = getVideoId()
    videoId ? setIframSrc(videoId) : alert('invalid url')
  }
  const handlePress = ({ key }) => {
    if (key === 'Enter') {
      const videoId = getVideoId()
      videoId ? setIframSrc(videoId) : alert('invalid url')
    }
  }
  function getVideoId() {
    const videoLink = inputEvent.value
    const videoLinkSplit = videoLink.split('v=')
    return videoLinkSplit.length !== 2 ? null : videoLinkSplit[1]
  }
  return (
    <div>
      <main role="main" className="px-3">
        <h1>Youtube Creator를 위한 댓글 추첨 사이트</h1>
        <SearchInput inputEvent={inputEvent} handleClick={handleClick} handlePress={handlePress} />
      </main>
      <iframe
        id="player"
        type="text/html"
        width="640"
        height="360"
        src={`http://www.youtube.com/embed/${iframSrc}?enablejsapi=1`}
        frameborder="0"
      />
    </div>
  )
}

export default Home
