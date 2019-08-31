import React from 'react'
import useInput from '../../hooks/use-input'

const SearchInput = () => {
  const inputEvent = useInput('')
  return (
    <div className="input-group mb-3">
      <input
        type="text"
        className="form-control"
        placeholder="유튜브 영상 주소를 입력하세요."
        aria-describedby="button-addon2"
        {...inputEvent}
      />
      <div className="input-group-append">
        <button className="btn btn-outline-secondary" type="button" id="button-addon2">
          search
        </button>
      </div>
    </div>
  )
}
export default SearchInput
