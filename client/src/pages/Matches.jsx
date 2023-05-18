import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import axios from "axios";
import { Link, Navigate } from "react-router-dom";
import { Box, Grid, TextField } from "@material-ui/core";

const CreateMatch = ({handleCreateMatch}) => {
  const [location,setLocation] = React.useState([])
  const [date,setDate] = React.useState("")
  const [time,setTime]= React.useState("")
  const [textareaValue, setTextareaValue] = useState("");
  const [textColor, setTextColor] = useState('red');

  console.log("hej fra PostMatch component ")
  
  const postMatch = async () => {
    try {
      const match = { location, date, time }; 
      console.log(match);
      await axios.post("http://localhost:8080/api/match/createMatch", match);
      setTextColor("green")
      setTextareaValue("Match created successfully!");
      
      handleCreateMatch();
      
    } catch (err) {
      console.log(err);
      setTextColor("red")
      setTextareaValue("make sure to fill all the inputs correctly");
    }
  };
 
  
  return (
    <div>
          <div className="input-wrapper">
            <TextField 
            label="Location" className="input" type="text" fullWidth onChange={(e) => setLocation(e.target.value)}
            
            />
            <TextField 
            label="date format is yyyy-mm-dd" className="input" type="text" fullWidth onChange={(e) => setDate(e.target.value)}
            
            />
            <TextField label="time format is hh:mm:ss" className="input" type="text" fullWidth onChange={(e) => setTime(e.target.value)} 
            
            />
            <button className="button" onClick={() => postMatch()}>create match</button>
            <textarea
            name="myTextarea"
            id="myTextarea"
            cols="40"
            rows="3"
            style={{ resize: 'none', border: 'none' ,color:textColor}}
            value={textareaValue}
            readOnly
            ></textarea>
          </div>
    
    </div>
  );
};


const Matches = ({ matches, setMatches, handleMatchClick}) => {
  const [refresh, setRefresh] = useState(false);

  useEffect(() => {

    const fetchAllMatches = async () => {
      try {
        const res = await axios.get("http://localhost:8080/api/match/getMatches");
        setMatches(res.data);
        console.log(res)
      } catch (err) {
        console.log(err);
      }
    };
    fetchAllMatches();
  }, [setMatches, refresh]);

  const handleCreateMatch = () => {
    setRefresh(true);
  };

  return (
    <div>
      <Grid container spacing={2}>
        <Grid item xs={12} sm={6} md={8}>
        <h1>Matches</h1>
          <div className="match">
            {matches.map((match) => (
              <Link
                to={`/getPlayerParticipations/${match.id}`}
                onClick={() => handleMatchClick(match.id)}
                key={match.id}
              >
                <div key={match.id} className="match">
                  <p>{match.location}</p>
                  <p>{match.date[0]}-{match.date[1]}-{match.date[2]}</p>
                  <p>{match.time[0]}:{match.time[1].toString().padStart(2, '0')}</p>
                  <p>id={match.id}</p>
                </div>
              </Link>
            ))}
          </div>
        </Grid>
        <Grid item xs={12} sm={6} md={4} >
          <CreateMatch handleCreateMatch={handleCreateMatch} />
        </Grid>
      </Grid>
    </div>
  );
};


export default Matches;

