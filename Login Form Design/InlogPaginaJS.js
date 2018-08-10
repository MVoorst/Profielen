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
	console.log(">>>>>>>>");
	var mailParticipant = (document.getElementById("email").value);
	var usernameParticipant = (document.getElementById("Voornaam").value);
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
		    //getpass(mailParticipant, usernameParticipant0);
		 	}
	};

	yhttp.open("POST", "http://localhost:8082/api/useraccount", true);
	yhttp.setRequestHeader ("content-type", "application/json");
	yhttp.send(newParticipantjson);
	sendUserCreatedMail(nieuweUser);

}

function nieuweNAW() {
	console.log(">>>>NAW>>>>");
	var uservoornameParticipant = (document.getElementById("Voornaam").value);
	var userachternameParticipant = (document.getElementById("Achternaam").value);
	var usertussenvoegselParticipant = (document.getElementById("Tussenvoegsel").value);
	var streetParticipant = (document.getElementById("Straat").value);
	var huisnummerParticipant = (document.getElementById("Huisnummer").value);
	var postcodeParticipant = (document.getElementById("Postcode").value);
	var stadParticipant = (document.getElementById("Woonplaats").value);
	var yhttp = new XMLHttpRequest();

	var newParticipant = {};
	newParticipant.voonaam = uservoornameParticipant;
	newParticipant.achternaam = userachternameParticipant;
	newParticipant.tussenvoegsel = usertussenvoegselParticipant;
	newParticipant.adres = streetParticipant;
	newParticipant.huisnummer = huisnummerParticipant;
	newParticipant.postcode = postcodeParticipant;
	newParticipant.woonplaats = stadParticipant;
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
		    getpass(mailParticipant, usernameParticipant0);
		 	}
	};

	yhttp.open("POST", "http://localhost:8082/api/useraccount", true);
	yhttp.setRequestHeader ("content-type", "application/json");
	yhttp.send(newParticipantjson);

}

function getPass (mailParticipant, usernameParticipant) {
	console.log("getPass running..")
	var zhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		console.log(this.readyState + this.status);
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
	 			var registratiesleutel = gevondenPersoon.wachtwoord;
	 		}

    	}
	};
	}
		zhttp.open("GET", "http://localhost:8082/api/useraccount");
		zhttp.setRequestHeader ("content-type", "application/json");
		zhttp.send();	

	window.open('mailto: mailParticipant+?subject = "Registratiesleutel" & body = "Gebruikersnaam  = " + usernameParticipant + "Wachtwoord  = " Registratiesleutel');
}

//met deze functie stuurt de browser een mail.
function sendUserCreatedMail(){
			var nodemailer = require('nodemailer');

		var transporter = nodemailer.createTransport({
		  service: 'gmail',
		  auth: {
			user: 'testwerktmailennaarcrispijn@gmail.com',
			pass: 'qien18Kobalt11'
		  }
		});

		var mailOptions = {
		  from: 'testwerktmailennaarcrispijn@gmail.com',
		  to: 'crispijn.sleeboom@gmail.com, marjolijn_voorst@live.nl, Tes@vdvlist.net, ' 
		  subject: 'testmailtje jongens',
		  text: 'Hallo allemaal, dit is even een test of mailen lukt via een knop op de browser'
		};

		transporter.sendMail(mailOptions, function(error, info){
		  if (error) {
			console.log(error);
		  } else {
			console.log('Email sent: ' + info.response);
		  }
		});
}
			
function send() {
  setTimeout(function() {
    window.open("mailto:" + document.getElementById('email').value + "?subject=" + document.getElementById('subject').value + "&body=" + document.getElementById('message').value);
  }, 320);
}
