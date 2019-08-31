import React, { useEffect } from 'react'
import { useDispatch } from 'react-redux'
import queryString from 'query-string'
import { getAccessToken } from '../../apis/access-token'
import { LOGIN, LOGOUT } from '../../store/modules/login'

const Login = ({ location, history }) => {
  const dispatch = useDispatch()
  function isEmpty(map) {
    if (Object.keys(map).length == 0) return true
    else return false
  }
  async function getToken() {
    const query = queryString.parse(location.search)
    if (isEmpty(query)) history.push('/')
    const response = await getAccessToken(query.code)
    if (response) {
      console.log('로그인')
      dispatch({ type: LOGIN })
      history.push('/mypage')
    } else {
      console.log('로그인 실패')
      dispatch({ type: LOGOUT })
      history.push('/')
    }
  }
  useEffect(() => {
    getToken()
  })
  return <div>Loading...</div>
}

export default Login
