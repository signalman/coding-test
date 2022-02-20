case 'L':
        if(s[1]=='+'){
          swap(cube[0][0][0],cube[2][0][0]);
          swap(cube[0][1][0],cube[2][1][0]);
          swap(cube[0][2][0],cube[2][2][0]);
          
          swap(cube[0][0][0],cube[3][0][2]);
          swap(cube[0][1][0],cube[3][1][2]);
          swap(cube[0][2][0],cube[3][2][2]);

          swap(cube[1][0][0],cube[3][0][2]);
          swap(cube[1][1][0],cube[3][1][2]);
          swap(cube[1][2][0],cube[3][2][2]);