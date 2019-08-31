import React from 'react'
import { Route, Switch } from 'react-router-dom'
import './App.css'
import Navigation from './components/navigation'
import Footer from './components/footer'
import Home from './containers/home'
import NotFound from './containers/NotFound'

function App() {
  return (
    <div className="App w-100 h-100">
      <div className="d-flex w-100 h-100 p-3 mx-auto flex-column">
        <Navigation />
        <Switch>
          <Route path="/" component={Home} />
          <Route component={NotFound} />
          <Home />
        </Switch>
        <Footer />
      </div>
    </div>
  )
}

export default App
