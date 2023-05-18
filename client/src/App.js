import { BrowserRouter, Routes, Route } from "react-router-dom";
import Matches from "./pages/Matches";
import Playerparticipations from "./pages/Playerparticipations";
import Players from "./pages/Players"
import React from "react";

function App() {
  const [matches, setMatches] = React.useState([]);
  const [playerparticipations, setPlayerparticipations] = React.useState([]);
  const [player,setPlayer] = React.useState([])
  const [param, setParam] = React.useState(null);

  const handleMatchClick = (val) => {
    console.log("handleClick App")
    setParam(val);
  };

  const handlePlayerparticipationClicked = (val) => {
    console.log("handlePlayerparticipationClicked App")
    setParam(val);
  };

  

  return (
    <div className="app">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Matches matches={matches} setMatches={setMatches} handleClick={handleMatchClick} />} />
          <Route path="/getPlayerParticipations/:id" element={<Playerparticipations playerparticipations={playerparticipations} setPlayerparticipations={setPlayerparticipations} param={param} handlePlayerparticipationClicked={handlePlayerparticipationClicked} />} />
          <Route path="/getPlayer/:id" element={<Players player={player} setPlayer={setPlayer} param={param}/>} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}


export default App;
