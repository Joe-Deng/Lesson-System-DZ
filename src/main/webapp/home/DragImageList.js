// ;function addLoadEvent(func){
//   var oldonload = window.onload; //把现在有window.onload事件处理函数的值存入变量oldonload。
//   if(typeof window.onload != 'function'){ //如果这个处理函数还没有绑定任何函数，就像平时那样把新函数添加给它
//     window.onload = DragImageList();
//   }else{ //如果在这个处理函数上已经绑定了一些函数。就把新函数追加到现有指令的末尾
//     window.onload = function(){
//       oldonload();
//       DragImageList();
//     }
//   }
//
// }
window.addEventListener("load",DragImageList)

function DragImageList(){
  //1.侧边栏图片可被拖动
  function handleImgDragstart(e) {
    //通过计算属性获取背景图片
    const backgroundImg = window.getComputedStyle(e.target.children[0], null).backgroundImage;
    e.dataTransfer.setData("text/explain", backgroundImg); //用于传输值的媒介
    console.log(e.dataTransfer.getData("text/explain"));
  }


  //2.droppableImage可以接受被拖拽的元素并创建图片
  const droppableImage = document.querySelectorAll(".droppableImage");

  droppableImage.forEach((item, index) => {
    droppableEvents(item);
  })

  //事件绑定封装
  function droppableEvents(item) {
    item.addEventListener("dragover", handleDragover);

    function handleDragover(e) {
      //preventDefault()，默认事件是当鼠标拖拽物体经过时，会出现 Φ 符号，而阻止默认事件后会显示该区域可防止的效果
      e.preventDefault();
      item.classList.add("dropover");
    }

    item.addEventListener("dragleave", handleDragleave);

    function handleDragleave(e) {
      item.classList.remove("dropover")
    }

    item.addEventListener("drop", handleImgDrop);

    function handleImgDrop(e) {
      const backgroundImg = e.dataTransfer.getData("text/explain");
      item.style.backgroundImage = backgroundImg;
      item.classList.add("dropped");
      e.stopPropagation(); //阻止事件冒泡
    }

    item.ondblclick = e => {
      // console.log(item.parentNode);
      item.parentNode.classList.forEach((classname, index) => {
        if (classname == "lock") {
          //如果锁上，就解锁
          item.parentNode.classList.remove("lock");
          return false;
        }
        item.parentNode.classList.add("lock"); //锁定
      })
    }
  }





  //3.ImageList的li的文字双击切换成输入框
  let imageList = document.querySelectorAll(".imageList li");

  //给每一个imageList元素添加事件
  imageList.forEach(function(item, index) {
    const p = item.children[1];
    const textarea = item.children[2];
    item.addEventListener("dragstart", handleImgDragstart);
    p.ondblclick = () => {
      p.style.display = "none";
      textarea.style.display = "inline-block";
      textarea.addEventListener("keydown", handleKeydown)
      event.stopPropagation(); //阻止事件冒泡
    };

    textarea.onclick = () => {
      event.stopPropagation(); //阻止事件冒泡
    }
  })

  //4.当点击屏幕的其他地方ImageList的li切换回文字
  //检测屏幕点击
  document.body.addEventListener("click", () => {
    inputEnd();
  })
  // 检测回车键
  function handleKeydown(e) {
    // console.log(e.keyCode);
    if (e.keyCode == 13) {
      // e.preventDefault();
      inputEnd();
    }
  }

  function inputEnd() {
    //判断是否有文本框显示
    imageList.forEach(function(item, index) {
      const p = item.children[1];
      const textarea = item.children[2];
      if (textarea.style.display == "inline-block") {
        let text = textarea.value; //保存文本框内容
        if (text == "") {
          //默认命名为“未命名”
          text = "未命名"
        }
        p.innerHTML = text;
        textarea.style.display = "none";
        p.style.display = "inline-block";
      }
    })
  }

  //5.pullback按钮点击事件（锁定，解锁浮动）
  const pullback = document.querySelector("#pullback");
  pullback.addEventListener("click", handlePullback);

  function handlePullback(e) {
    // if(pullback.parentNode.offsetLeft>-130){
    //   //拉回去
    //   pullback.parentNode.style.left
    // }
    pullback.parentNode.classList.forEach(function(item, index) {
      if (item == "movable") {
        console.log("1");
        //锁定侧边栏
        pullback.parentNode.classList.remove("hide");
        pullback.parentNode.classList.remove("movable");
        return false;
      }
      //解除锁定
      pullback.parentNode.classList.add("hide")
      pullback.parentNode.classList.add("movable");
      console.log(pullback.parentNode.classList);
    })
  }


  //6.添加和删除图片按钮点击事件
  const addImgBtn = document.querySelector("#addImg");
  const removeImgBtn = document.querySelector("#removeImg");
  addImgBtn.addEventListener("click", openField);

  function openField(){
    let filed = document.getElementById("uploadField");
    filed.style.display="block";
  }
  //关闭上传栏
  const closeFieldBtn = document.getElementById("closeFieldBtn");
  closeFieldBtn.addEventListener("click",closeField);
  function closeField(){
    let filed = document.getElementById("uploadField");
    filed.style.display="none";
  }


  //7.实现将draggable-image拖到main-container中，自动创建一个mImgContent、box、droppableImage;
  const container = document.getElementsByClassName("main-container")[0];
  container.addEventListener("drop", addNewNode);
  container.addEventListener("dragover", function(e) {
    e.preventDefault();
  })

  function addNewNode(e) {
    e.preventDefault();
    const newContent = document.createElement("div");
    const newBox = document.createElement('div');
    const newDroppableImage = document.createElement("div");
    newContent.classList.add("mImgContent");
    newBox.classList.add("box");
    newDroppableImage.classList.add("droppableImage");
    newDroppableImage.classList.add("dropped");
    //设置背景图
    newDroppableImage.style.backgroundImage = e.dataTransfer.getData("text/explain");
    //组合到一起
    newBox.appendChild(newDroppableImage);
    newContent.appendChild(newBox);
    //添加到容器
    container.appendChild(newContent);
    //给它添加绑定事件
    droppableEvents(newDroppableImage);
    //屏幕自动滑动，以显示完全新添加的图片
    scrollDown(container, newContent.offsetHeight)
  }

  //向下滑动多少
  var timer;
  let maxDistance;


  //自动滚动到底部  的函数，必传参数：滚动容器对象，新添加节点的高度
  function scrollDown(container, distance, time = 1000, flagPS = 60) {
    console.log(timer);
    console.log(distance);
    if (timer != null && timer != undefined) {
      timer = clearInterval(timer);
      container.scrollTop = maxDistance - distance;
    }
    if (container.scrollHeight > container.clientHeight + distance / 2) {
      //如果内容高度超出屏幕+distance,那么向下滚动distance
      // container.scrollTop += distance;
      //取代上面的方法，选择直接滚到最下面
      //最大可滚动高度
      maxDistance = container.scrollHeight - container.clientHeight;
      //如果上次动画没结束，强制结束
      console.log("1/FlagPs" + 1 / flagPS);
      //总共运行的帧数，向下取整走的越少越好（防止超出滚动范围)
      let flags = Math.floor(flagPS * time / 1000);
      //每帧移动的距离
      let distancePerFlag = maxDistance / (flags);
      // console.log("distancePerFlag:" + distancePerFlag);
      //scrollTop是浮点型变量，而container.scrollTop是整形，所以用前者作为计算标准
      //(因为一旦每帧距离小于1就会因为向下取整等于0，相加后导致屏幕不运动)
      let scrollTop = container.scrollTop;
      //开始动画
      timer = setInterval(() => {
        scrollTop += distancePerFlag;
        container.scrollTop = scrollTop;
        console.log(scrollTop);
        console.log(container.scrollTop);
        //最后一帧直接滚到最底部,关闭动画
        if (scrollTop >= maxDistance) {
          //清除timer定时器
          timer = clearInterval(timer);
          container.scrollTop = maxDistance;
        }
      }, 1000 / flagPS)
    }
  }
}