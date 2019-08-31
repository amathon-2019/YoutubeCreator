import React from 'react'

const DrawList = ({ drawList }) => {
  return (
    <div className="cover-container mx-auto text-secondary">
      <ul className="list-group">
        {drawList.map(item => {
          return <li className="list-group-item">{item.name}</li>
        })}
      </ul>
    </div>
  )
}

export default DrawList
