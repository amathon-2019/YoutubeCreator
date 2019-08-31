import React from 'react'
import { BrowserRouter, Route, Switch } from 'react-router-dom'
import { Provider } from 'react-redux'
import Alert from 'react-s-alert'
import store from './store'
import './App.css'
import Navigation from './components/navigation'
import Footer from './components/footer'
import Home from './containers/home'
import Login from './containers/login'
import NotFound from './containers/not-found'
import Mypage from './containers/mypage'

function App() {
  return (
    <div className="App w-100 h-100">
      <div className="d-flex w-100 h-100 p-3 mx-auto flex-column">
        <BrowserRouter>
          <Provider store={store}>
            <Navigation />
            <Switch>
              <Route exact path="/" component={Home} />
              <Route exact path="/login" component={Login} />
              <Route exact path="/mypage" component={Mypage} />
              <Route component={NotFound} />
              <Home />
            </Switch>
            <Footer />
          </Provider>
        </BrowserRouter>
      </div>
      <Alert stack={true} timeout={3000} />
    </div>
  )
}

export default App
