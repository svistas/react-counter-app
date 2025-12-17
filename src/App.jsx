import { useState } from 'react'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="app">
      <div className="counter-container">
        <h1>React Counter</h1>
        <div className="counter-display">
          <span className="count-number">{count}</span>
        </div>
        <div className="button-group">
          <button 
            className="btn btn-decrement" 
            onClick={() => setCount(count - 1)}
          >
            - Decrement
          </button>
          <button 
            className="btn btn-reset" 
            onClick={() => setCount(0)}
          >
            Reset
          </button>
          <button 
            className="btn btn-increment" 
            onClick={() => setCount(count + 1)}
          >
            + Increment
          </button>
        </div>
        <div className="info">
          <p>A simple counter demo built with React</p>
        </div>
      </div>
    </div>
  )
}

export default App

