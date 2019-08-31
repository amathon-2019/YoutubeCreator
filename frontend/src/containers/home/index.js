import React from 'react'
import SearchInput from '../../components/search-input'

const Home = () => {
  return (
    <div>
      <main role="main" className="px-3">
        <h1>
          Youtube Creator를 위한 <p>댓글 추첨 사이트</p>
        </h1>
        <SearchInput />
      </main>
      <iframe
        id="player"
        type="text/html"
        width="640"
        height="360"
        src="http://www.youtube.com/embed/m32r3atf1rU?enablejsapi=1"
        frameborder="0"
      ></iframe>
    </div>
  )
}

export default Home
