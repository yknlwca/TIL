function Start() {
	(async () => {
		const avatar = await REDBRICK.AvatarManager.createDefaultAvatar();
		const camera = WORLD.getObject("MainCamera");
		const followingCamera = avatar.setFollowingCamera(camera);
		avatar.setDefaultController();
		let myMoney = 1000; //보유금
        let betMoney = 0; //배팅금
        let ratio = 2;  //배율
		const current = GUI.getObject("current");
		const bet = GUI.getObject("bet");
		current.setText("보유금: " + myMoney + " (만 원)");
        bet.setText("배팅금: " + betMoney + " (만 원)");
		
		const mesh1 = WORLD.getObject("mesh1");
		const resultMesh1 = WORLD.getObject("resultMesh1");
		const board = GUI.getObject("board");
		board.hide();
		
		const bet100_1 = WORLD.getObject("foods_dgapple_001(f88)");
		const bet500_1 = WORLD.getObject("foods_dgapple_001(8db)");
		const bet1000_1 = WORLD.getObject("foods_dgapple_001(36e)");
		bet100_1.onCollide(avatar, ()=>{
            myMoney -= 100;
            betMoney += 100;
            current.setText("보유금: " + myMoney + " (만 원)");
            bet.setText("배팅금: " + betMoney + " (만 원)");
        })
        bet500_1.onCollide(avatar, ()=>{
            myMoney -= 500;
            betMoney += 500;
            current.setText("보유금: " + myMoney + " (만 원)");
            bet.setText("배팅금: " + betMoney + " (만 원)");
        })
        bet1000_1.onCollide(avatar, ()=>{
            myMoney -= 1000;
            betMoney += 1000;
            current.setText("보유금: " + myMoney + " (만 원)");
            bet.setText("배팅금: " + betMoney + " (만 원)");
        })
		avatar.onCollide(mesh1, () => {
		    board.setText("배율 2배!\n배팅 금액을 선택해주세요.");
		    board.show();
		})
		avatar.onCollide(resultMesh1, () => {
		    board.setText("성공!");
		    myMoney += betMoney * ratio;
		    betMoney = 0;   
		    current.setText("보유금: " + myMoney + " (만 원)");
            bet.setText("배팅금: " + betMoney + " (만 원)");
		})
		
		
		const bet100_2 = WORLD.getObject("foods_dgapple_001(ae5)");
		const bet500_2 = WORLD.getObject("foods_dgapple_001(83e)");
		const bet1000_2 = WORLD.getObject("foods_dgapple_001(137)");
		bet100_2.onCollide(avatar, ()=>{
            myMoney -= 100;
            betMoney += 100;
            current.setText("보유금: " + myMoney + " (만 원)");
            bet.setText("배팅금: " + betMoney + " (만 원)");
        })
        bet500_2.onCollide(avatar, ()=>{
            myMoney -= 500;
            betMoney += 500;
            current.setText("보유금: " + myMoney + " (만 원)");
            bet.setText("배팅금: " + betMoney + " (만 원)");
        })
        bet1000_2.onCollide(avatar, ()=>{
            myMoney -= 1000;
            betMoney += 1000;
            current.setText("보유금: " + myMoney + " (만 원)");
            bet.setText("배팅금: " + betMoney + " (만 원)");
        })
		const mesh2 = WORLD.getObject("mesh2");
		const resultMesh2 = WORLD.getObject("resultMesh2");
		avatar.onCollide(mesh2, () => {
		    board.setText("배율 3배!\n배팅 금액을 선택해주세요.");
		    ratio = 3;
		    board.show();
		})
		avatar.onCollide(resultMesh2, () => {
		    board.setText("성공!");
		     myMoney += betMoney * ratio;
		    betMoney = 0;   
		    current.setText("보유금: " + myMoney + " (만 원)");
            bet.setText("배팅금: " + betMoney + " (만 원)");
		})
		
		
		const bet100_3 = WORLD.getObject("foods_dgapple_001(c79)");
		const bet500_3 = WORLD.getObject("foods_dgapple_001(3c6)");
		const bet1000_3 = WORLD.getObject("foods_dgapple_001(65d)");
		bet100_3.onCollide(avatar, ()=>{
            myMoney -= 100;
            betMoney += 100;
            current.setText("보유금: " + myMoney + " (만 원)");
            bet.setText("배팅금: " + betMoney + " (만 원)");
        })
        bet500_3.onCollide(avatar, ()=>{
            myMoney -= 500;
            betMoney += 500;
            current.setText("보유금: " + myMoney + " (만 원)");
            bet.setText("배팅금: " + betMoney + " (만 원)");
        })
        bet1000_3.onCollide(avatar, ()=>{
            myMoney -= 1000;
            betMoney += 1000;
            current.setText("보유금: " + myMoney + " (만 원)");
            bet.setText("배팅금: " + betMoney + " (만 원)");
        })
		const mesh3 = WORLD.getObject("mesh3");
		const resultMesh3 = WORLD.getObject("resultMesh3");
		avatar.onCollide(mesh3, () => {
		    board.setText("배율 5배!\n배팅 금액을 선택해주세요.");
		    ratio = 5;
		    board.show();
		})
		avatar.onCollide(resultMesh3, () => {
		    board.setText("성공!");
		    myMoney += betMoney * ratio;
		    betMoney = 0;   
		    current.setText("보유금: " + myMoney + " (만 원)");
            bet.setText("배팅금: " + betMoney + " (만 원)");
		})
		
		const bet100_4 = WORLD.getObject("foods_dgapple_001(8e0)");
		const bet500_4 = WORLD.getObject("foods_dgapple_001(7c3)");
		const bet1000_4 = WORLD.getObject("foods_dgapple_001(dac)");
		const mesh4 = WORLD.getObject("mesh4");
		const resultMesh4 = WORLD.getObject("resultMesh4");
		
        bet100_4.onCollide(avatar, ()=>{
            myMoney -= 100;
            betMoney += 100;
            current.setText("보유금: " + myMoney + " (만 원)");
            bet.setText("배팅금: " + betMoney + " (만 원)");
        })
        bet500_4.onCollide(avatar, ()=>{
            myMoney -= 500;
            betMoney += 500;
            current.setText("보유금: " + myMoney + " (만 원)");
            bet.setText("배팅금: " + betMoney + " (만 원)");
        })
        bet1000_4.onCollide(avatar, ()=>{
            myMoney -= 1000;
            betMoney += 1000;
            current.setText("보유금: " + myMoney + " (만 원)");
            bet.setText("배팅금: " + betMoney + " (만 원)");
        })
		avatar.onCollide(mesh4, () => {
		    board.setText("배율 10배!\n배팅 금액을 선택해주세요.");
		    ratio = 10;
		    board.show();
		})
		avatar.onCollide(resultMesh4, () => {
		    board.setText("실패!");
		    betMoney = 0;   
		    current.setText("보유금: " + myMoney + " (만 원)");
            bet.setText("배팅금: " + betMoney + " (만 원)");
		})
		
		const bet100_5 = WORLD.getObject("foods_dgapple_001(572)");
		const bet500_5 = WORLD.getObject("foods_dgapple_001(1f3)");
		const bet1000_5 = WORLD.getObject("foods_dgapple_001(1cf)");
		const mesh5 = WORLD.getObject("mesh5");
		const resultMesh5 = WORLD.getObject("resultMesh5");
		bet100_5.onCollide(avatar, ()=>{
            myMoney -= 100;
            betMoney += 100;
            current.setText("보유금: " + myMoney + " (만 원)");
            bet.setText("배팅금: " + betMoney + " (만 원)");
        })
        bet500_5.onCollide(avatar, ()=>{
            myMoney -= 500;
            betMoney += 500;
            current.setText("보유금: " + myMoney + " (만 원)");
            bet.setText("배팅금: " + betMoney + " (만 원)");
        })
        bet1000_5.onCollide(avatar, ()=>{
            myMoney -= 1000;
            betMoney += 1000;
            current.setText("보유금: " + myMoney + " (만 원)");
            bet.setText("배팅금: " + betMoney + " (만 원)");
        })
		avatar.onCollide(mesh5, () => {
		    board.setText("배율 20배!\n배팅 금액을 선택해주세요.");
		    ratio = 20;
		    board.show();
		})
		avatar.onCollide(resultMesh5, () => {
		    board.setText("실패!");
		    betMoney = 0;   
		    current.setText("보유금: " + myMoney + " (만 원)");
            bet.setText("배팅금: " + betMoney + " (만 원)");
		})
		
		
	})();
}
