import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import axios from "axios";
import { Link, Navigate } from "react-router-dom";

const Playerparticipations= ({playerparticipations, setPlayerparticipations,param}) => {
    console.log("hej fra Playerparticipations comp");
    console.log(param)
  
    useEffect(() => {
      const fetchAllPlayerparticipations = async () => {
        try {
          const res = await axios.get(`http://localhost:8080/api/getPlayerParticipations/${param}`);
          setPlayerparticipations(res.data);
          console.log(param);
          console.log(res)
        } catch (err) {
          console.log(err);
        }
      };
      fetchAllPlayerparticipations();
    }, [setPlayerparticipations,param]);
  
    
    return (
      <div>
        <h1>Playerparticipations</h1> 
        <div className="playerparticipation">
        {playerparticipations.map((playerparticipation) => (
            <div key={playerparticipation.id} className="playerparticipation">
              <p> cancelled : {playerparticipation.cancelled.toString()}</p>
              {playerparticipation.reason !== null && <p>reason: {playerparticipation.reason}</p>}
              <p>id:{playerparticipation.id}</p>
            </div>
            
            ))}
        </div>  
      </div>
    );
  };
  
  export default Playerparticipations;
  