if (window.console) {
  console.log("Welcome to your Play application's JavaScript!");
}
console.log("here is vlad!");
(function(data) {
  console.log("message = " + data)
}).call(this);


function namef (data1) {
	console.log("we are in the function");
	
  data = data1;
  console.log("message = " + data + "; typeof = " + (typeof data) //+
      //"; parse = " + JSON.parse(data) //+
      //"; stringify = " + JSON.stringify(""+data)
  );

  for (element in data1) {
    console.log("for in element = " + element + " data = " + data1[element]);
    console.log(data1[element].name);
  }

};

//window.onload = name (window.message);

//console.log(JSON.parse(applicants));