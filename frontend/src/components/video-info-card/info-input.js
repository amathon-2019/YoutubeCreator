import React from 'react'

const InfoInput = () => {
  return (
    <div className="mb-5">
      <div className="form-group mb-2">
        <h3>
          <label for="exampleFormControlSelect1">추첨인원</label>
        </h3>
        <select multiple className="form-control w-50 mx-auto" id="exampleFormControlSelect1">
          <option>1</option>
          <option>2</option>
          <option>3</option>
          <option>4</option>
          <option>5</option>
          <option>6</option>
          <option>7</option>
          <option>8</option>
          <option>9</option>
        </select>
      </div>
      <h3>
        <label for="exampleFormControlSelect2">구독 여부</label>
      </h3>
      <div id="exampleFormControlSelect2">
        <div className="form-check form-check-inline">
          <input
            className="form-check-input"
            type="checkbox"
            id="inlineCheckbox1"
            value="option1"
          />
          <label className="form-check-label" for="inlineCheckbox1">
            구독
          </label>
        </div>
      </div>
    </div>
  )
}

export default InfoInput
