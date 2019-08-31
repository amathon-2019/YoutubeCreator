import { useState } from 'react'

function useInput(initValue) {
  const [value, setValue] = useState(initValue)
  const onChange = ({ target }) => {
    setValue(target.value)
  }
  return { value, onChange }
}

export default useInput
