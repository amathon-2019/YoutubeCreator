import React from 'react'
import { NavLink } from 'react-router-dom'

const Navigation = () => {
  return (
    <header className="mb-auto">
      <div>
        <h3 className="float-md-left mb-0">YOUTUBE</h3>
        <nav className="nav nav-masthead justify-content-center float-md-right">
          <NavLink className="nav-link" activeClassName="active" exact={true} to="/">
            Home
          </NavLink>
          <NavLink className="nav-link" activeClassName="active" exact={true} to="/login">
            Login
          </NavLink>
        </nav>
      </div>
    </header>
  )
}

export default Navigation
