import React, { useEffect } from 'react'
import { useSelector } from 'react-redux'
const Mypage = ({ history }) => {
  const { login } = useSelector(state => state.login)
  useEffect(() => {
    if (!login) {
      history.push('/')
    }
  }, [login])
  return <div>mypage</div>
}

export default Mypage
