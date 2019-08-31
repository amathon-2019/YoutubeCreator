import React from 'react'

const VideoCard = ({ videoId }) => {
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
    </div>
  )
}

export default VideoCard
