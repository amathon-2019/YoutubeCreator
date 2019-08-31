import React from 'react'
import './App.css'
import Navigation from './components/navigation'
import Footer from './components/footer'

function App() {
  return (
    <div className="App w-100 h-100">
      <div className="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
        <Navigation />
        <Footer />
      </div>
    </div>
  )
}

export default App
