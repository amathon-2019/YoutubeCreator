import React, { useEffect } from 'react'
import { getAccessToken } from '../../apis/access-token'

const Login = ({ location, history }) => {
  async function getToken() {
    const query = queryString.parse(location.search)
    if (isEmpty(query)) history.push('/')
    const response = await getAccessToken(query.code)
    if (response) {
      console.log(response)
      history.push('/mypage')
    } else {
      history.push('/')
    }
  }
  useEffect(() => {
    getToken()
  })
  return <div>Loading...</div>
}

export default Login
