;(function(window) {
  let player = new Player();

  function Player(left, top) {
    let playerContainer = document.createElement("div");
    playerContainer.style = {
      width: "300px",
      height: "400px",
      backGround: "#ff0000",
      position: "absolute",
      left: left,
      top: top
    }
    console.log(playerContainer);
  }
  window.Player = player;
  window.document.getElementsByTagName("div")[0].append(playerContainer);

})(window);