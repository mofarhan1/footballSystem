import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import axios from "axios";
import { Link, Navigate } from "react-router-dom";


const Matches = ({ matches, setMatches, handleClick }) => {
  useEffect(() => {
    const fetchAllMatches = async () => {
      try {
        const res = await axios.get("http://localhost:8080/api/getMatches");
        setMatches(res.data);
      } catch (err) {
        console.log(err);
      }
    };
    fetchAllMatches();
  }, [setMatches]);

  return (
    <div>
      <h1>Matches</h1>
      <div className="match">
        {matches.map((match) => (
          <Link to={`/getPlayerParticipations/${match.id}`} onClick={() => handleClick(match.id)} key={match.id}>
            <div key={match.id} className="match">
              <p>{match.location}</p>
              <p>{match.date}</p>
              <p>{match.time}</p>
              <p>id={match.id}</p>
            </div>
          </Link>
        ))}
      </div>
    </div>
  );
};

export default Matches;

