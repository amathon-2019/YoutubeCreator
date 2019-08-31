import React, { Fragment } from 'react'

const Collapse = () => {
  return (
    <Fragment>
      <p>
        <button
          className="btn btn-primary"
          type="button"
          data-toggle="collapse"
          data-target="#collapseBox"
          aria-expanded="false"
          aria-controls="collapseBox"
        >
          추첨내용 입력
        </button>
      </p>
      <div className="collapse" id="collapseBox">
        <div className="card card-body">몇명을 추첨할까요?</div>
      </div>
    </Fragment>
  )
}

export default Collapse
