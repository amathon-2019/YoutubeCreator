import React from 'react'
import { useSelector } from 'react-redux'
import { NavLink } from 'react-router-dom'
import youtube_config from '../../youtube_config.json'

const Navigation = () => {
  const { login } = useSelector(state => state.login)
  const openOAuthPage = () => {
    if (!login) {
      const url = `https://accounts.google.com/o/oauth2/auth?client_id=${youtube_config.CLIENT_ID}&scope=https://www.googleapis.com/auth/youtube&redirect_uri=${process.env.REACT_APP_REDIRECT_URI}&response_type=code&
          access_type=offline`
      window.location.href = url
    }
  }
  return (
    <header className="mb-auto">
      <div>
        <h3 className="float-md-left mb-0">YOUTUBE</h3>
        <nav className="nav nav-masthead justify-content-center float-md-right">
          <NavLink className="nav-link" activeClassName="active" exact={true} to="/">
            Home
          </NavLink>
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
