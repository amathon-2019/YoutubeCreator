import React from 'react'

const ChannelInfoCard = ({ iframSrc, videoInfo }) => {
  return (
    <div className="card mb-4 shadow-sm mx-auto cover-container">
      <div className="card-header">
        <iframe
          id="player"
          type="text/html"
          width="640"
          height="360"
          src={`http://www.youtube.com/embed/${iframSrc}?enablejsapi=1`}
          frameBorder="0"
        />
      </div>
      <div className="card-body text-primary">
        <ul className="list-unstyled mt-3 mb-4">
          <li>View: {videoInfo ? videoInfo.viewCount : 0}</li>
          <li>Like: {videoInfo ? videoInfo.likeCount : 0}</li>
          <li>Comments: {videoInfo ? videoInfo.commentCount : 0}</li>
        </ul>
        <button type="button" className="btn btn-lg btn-block btn-primary">
          댓글 불러오기
        </button>
      </div>
    </div>
  )
}

export default ChannelInfoCard
