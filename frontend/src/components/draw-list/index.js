import React from 'react'

const DrawList = ({ drawList }) => {
  return (
    <div>
      <ul className="list-group">
        {drawList.map(item => (
          <li className="list-group-item">{item.authorName}</li>
        ))}
      </ul>
    </div>
  )
}

export default DrawList
