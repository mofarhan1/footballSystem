import { BrowserRouter, Routes, Route } from "react-router-dom";
import Matches from "./pages/Matches";
import Playerparticipations from "./pages/Playerparticipations";
import React from "react";

function App() {
  const [matches, setMatches] = React.useState([]);
  const [playerparticipations, setPlayerparticipations] = React.useState([]);
  const [param, setParam] = React.useState(null);

  const handleClick = (val) => {
    console.log("handleClick App")
    setParam(val);
  };

  return (
    <div className="app">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Matches matches={matches} setMatches={setMatches} handleClick={handleClick} />} />
          <Route path="/getPlayerParticipations/:id" element={<Playerparticipations playerparticipations={playerparticipations} setPlayerparticipations={setPlayerparticipations} param={param} />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}


export default App;
