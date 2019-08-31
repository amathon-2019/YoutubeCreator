import React from 'react'
import { useSelector, useDispatch } from 'react-redux'
import { NavLink } from 'react-router-dom'
import Alert from 'react-s-alert'
import youtube_config from '../../youtube_config.json'
import { LOGOUT } from '../../store/modules/login'

const Navigation = () => {
  const dispatch = useDispatch()
  const { login } = useSelector(state => state.login)
  const openOAuthPage = () => {
    if (!login) {
      const url = `https://accounts.google.com/o/oauth2/auth?client_id=${youtube_config.CLIENT_ID}&scope=https://www.googleapis.com/auth/youtube&redirect_uri=${process.env.REACT_APP_REDIRECT_URI}&response_type=code&
          access_type=offline`
      window.location.href = url
    } else {
      console.log('로그아웃')
      Alert.success('<h4>로그아웃<h4>', {
        position: 'top-right',
        effect: 'slide',
        html: true,
      })
      dispatch({ type: LOGOUT })
    }
  }
  return (
    <header className="mb-auto">
      <div>
        <h3 className="float-md-left mb-0">
          <NavLink exact={true} to="/">
            YOUTUBE
          </NavLink>
        </h3>
        <nav className="nav nav-masthead justify-content-center float-md-right">
          {login && (
            <NavLink className="nav-link" activeClassName="active" exact={true} to="/mypage">
              My page
            </NavLink>
          )}
          <div className="nav-link" onClick={openOAuthPage}>
            {login ? 'LOGOUT' : 'LOGIN'}
          </div>
        </nav>
      </div>
    </header>
  )
}

export default Navigation
