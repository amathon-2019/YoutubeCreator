import React from 'react'

const SearchInput = ({ inputEvent, handleClick, handlePress }) => {
  return (
    <div className="input-group mb-3 cover-container mx-auto">
      <input
        type="text"
        className="form-control"
        placeholder="유튜브 영상 주소를 입력하세요."
        aria-describedby="button-addon2"
        {...inputEvent}
        onKeyPress={handlePress}
      />
      <div className="input-group-append">
        <button
          className="btn btn-outline-secondary"
          type="button"
          id="button-addon2"
          onClick={handleClick}
        >
          search
        </button>
      </div>
    </div>
  )
}

export default SearchInput
