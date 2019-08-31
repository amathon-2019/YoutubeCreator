import { createAction, handleActions } from 'redux-actions'

// 액션 타입을 정의해줍니다.
export const LOGIN = 'auth/LOGIN'
export const LOGOUT = 'auth/LOGOUT'

export const login = createAction(LOGIN)
export const logout = createAction(LOGOUT)

const initialState = {
  login: false,
}

export default handleActions(
  {
    [LOGIN]: (state, action) => {
      if (!state.login) {
        return { login: true }
      }
    },
    [LOGOUT]: (state, action) => {
      if (state.login) {
        sessionStorage.clear()
        return { login: false }
      }
    },
  },
  initialState,
)
