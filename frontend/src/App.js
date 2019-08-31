import React from 'react'
import './App.css'
import Navigation from './components/navigation'
import Footer from './components/footer'
import Home from './containers/home'

function App() {
  return (
    <div className="App w-100 h-100">
      <div className="d-flex w-100 h-100 p-3 mx-auto flex-column">
        <Navigation />
        <Home />
        <Footer />
      </div>
    </div>
  )
}

export default App
