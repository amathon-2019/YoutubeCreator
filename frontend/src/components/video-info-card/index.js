import React from 'react'
import InfoInput from './info-input'

const VideoInfoCard = ({ videoId, videoInfo, onClick }) => {
  return (
    <div className="card mb-4 shadow-sm mx-auto cover-container">
      <div className="card-header">
        <iframe
          id="player"
          type="text/html"
          width="640"
          height="360"
          src={`http://www.youtube.com/embed/${videoId}?enablejsapi=1`}
          frameBorder="0"
        />
      </div>
      <div className="card-body text-secondary">
        <h3>영상정보</h3>
        <ul className="list-unstyled mt-3 mb-4">
          <li>View: {videoInfo ? videoInfo.viewCount : 0}</li>
          <li>Like: {videoInfo ? videoInfo.likeCount : 0}</li>
          <li>Comments: {videoInfo ? videoInfo.commentCount : 0}</li>
        </ul>
        <InfoInput />
        <button type="button" className="btn btn-lg btn-block btn-primary" onClick={onClick}>
          댓글 추첨
        </button>
      </div>
    </div>
  )
}

export default VideoInfoCard
