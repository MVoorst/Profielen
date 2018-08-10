function Inloggen() {
	console.log ("Inloggen..")
	var inlogUser = (document.getElementById("Username").value);
	var inlogPass = (document.getElementById("Password").value);
	var xhttp = new XMLHttpRequest();

	//var persoon = {};
	//var persoonJSON = JSON.stringify(persoon);
	//console.log (persoon);

	xhttp.onreadystatechange = function() {
		console.log(this.readyState) 
		console.log(this.status);
	 	  	if (this.readyState == 4 && this.status == 200) {
	  	   	console.log("Ready");
	     	console.log(this.responseText);
	     	var GetResponseIn = this.responseText;
	     	var inlogPersonenGetIn = JSON.parse(GetResponseIn);
	     	console.log(inlogPersonenGetIn);
	     	inloggenCheck(inlogPersonenGetIn, inlogPass, inlogUser);
     	
 	   }
	};
	xhttp.open("GET", "http://localhost:8082/api/adminaccount", true);
	xhttp.setRequestHeader ("content-type", "application/json");
	xhttp.send();
}

function inloggenCheck(inlogPersonenGetIn, inlogPass, inlogUser){
	console.log('Zoeken..')
	for (var index = 0; index < inlogPersonenGetIn.length; index++) {
	 	var gevondenPersoon = inlogPersonenGetIn[index];
	 	console.log(inlogUser);
	 	console.log(inlogPass);
	 	console.log(gevondenPersoon.gebruikersnaam);
		if (inlogUser == gevondenPersoon.gebruikersnaam ){
			console.log("Gevonden")
			if(inlogPass == gevondenPersoon.wachtwoord){
				console.log("Wachtwoord klopt!")
				document.location.href="AdminDashboard.html"
			} else {
				console.log ("wachtwoord fout");

			}
		} else {
		console.log("niet gevonden")
		//throw exception
		}
	}
}

function nieuweUser() {
	var mailParticipant = (document.getElementById("mail").value);
	var usernameParticipant = (document.getElementById("name").value);
	console.log(usernameParticipant);
	var yhttp = new XMLHttpRequest();

	var newParticipant = {};
		newParticipant.gebruikersnaam = usernameParticipant;
		newParticipant.emailadres = mailParticipant;
	var newParticipantjson = JSON.stringify(newParticipant);

	yhttp.onreadystatechange = function() {
		console.log(this.readyState) 
		console.log(this.status);
		 	if (this.readyState == 4 && this.status == 202) {
		  	console.log("Ready");
		    //console.log(this.responseText);
		    //var GetResponseIn = this.responseText;
		    //var ResponseIn = JSON.parse(GetResponseIn);
		    //console.log(ResponseIn);
		    getPass(mailParticipant, usernameParticipant);
		 	}
	};

	yhttp.open("POST", "http://localhost:8082/api/useraccount", true);
	yhttp.setRequestHeader ("content-type", "application/json");
	yhttp.send(newParticipantjson);

}

function getPass (mailParticipant, usernameParticipant) {
	console.log("getPass running..")
	console.log(usernameParticipant);
	var zhttp = new XMLHttpRequest();

	zhttp.onreadystatechange = function() {
		console.log(this.readyState);
		console.log( this.status);
   		if (this.readyState == 4 && this.status == 200) {
     		console.log("Ready");
     		console.log(this.responseText);
     		var GetResponseIn = this.responseText;
	     	var inlogPersonenGetIn = JSON.parse(GetResponseIn);
	     	console.log(inlogPersonenGetIn);
     		
	     	for (var index = 0; index < inlogPersonenGetIn.length; index++) {
	 		var gevondenPersoon = inlogPersonenGetIn[index];
	 		console.log(mailParticipant);
	 		console.log(usernameParticipant);
	 		console.log(gevondenPersoon.gebruikersnaam);
	 		if (usernameParticipant == gevondenPersoon.gebruikersnaam ){
	 			console.log("gelijk")
	 			var registratiesleutel = gevondenPersoon.wachtwoord;
	 			window.open('mailto: marjolijn_voorst@live.nl');
	 		} else{ console.log("niet gelijk")

	 		}

    		}
		};
	}
		zhttp.open("GET", "http://localhost:8082/api/useraccount");
		zhttp.setRequestHeader ("content-type", "application/json");
		zhttp.send();	

	
}

			

