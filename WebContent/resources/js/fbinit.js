function statusChangeCallback(response) {
    console.log(response);
    
    if (response.status === 'connected') {
      
      testAPI();
    } else if (response.status === 'not_authorized') {
      
    	console.log('Please log into this app.');
    } else {
      
    	console.log('Please log into Facebook.');
    }
  }

 
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }

  window.fbAsyncInit = function() {
  FB.init({
    appId      : '989385907738563',
    cookie     : true,  // enable cookies to allow the server to access 
                        // the session
    xfbml      : true,  // parse social plugins on this page
    version    : 'v2.2' // use version 2.2
  });
  
  FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  };
  
  function fb_login(){
	  FB.login(function(response) {
	  
		  console.log(response);
		  if (response.status === 'connected') {
		      
		      testAPI();
		    } else if (response.status === 'not_authorized') {
		      
		    	console.log('Please log into this app.');
		    } else {
		      
		    	console.log('Please log into Facebook.');
		    }		  
  }, {scope: 'public_profile,email,user_about_me,user_birthday',
	  return_scopes: true
	 });}
  
  function fb_logout(){
	  FB.logout(function(response) {
		  console.log(response);
		  document.getElementById("result").innerHTML = "";
		});
  }

  
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
    	var post = JSON.stringify(response);
    	//document.getElementById("result").innerHTML = "Welcome &nbsp;"+ response.first_name;
    	$.ajax({
        	type: "POST",
            url : 'loginfb',
            contentType: "application/json",
            data: post,
            success : function(data) {
            	alert(data);
                $('#result').html("Welcome &nbsp;"+ response.first_name);
            }
        });
    	console.log(res);
    });
  }