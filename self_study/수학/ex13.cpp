#include <iostream>
using namespace std;

int main(){
  string s="";
  string ans="";
  string ans1="";
  cin>>s;
  if(s!="0"){
  for(int i=0; i<s.size(); i++){
    if(s[i]=='0'){ans+="000";}
    else if(s[i]=='1'){ans+="001";}
    else if(s[i]=='2'){ans+="010";}
    else if(s[i]=='3'){ans+="011";}
    else if(s[i]=='4'){ans+="100";}
    else if(s[i]=='5'){ans+="101";}
    else if(s[i]=='6'){ans+="110";}
    else if(s[i]=='7'){ans+="111";}
  }

  bool flag=false;
  
  for(int i=0; i<ans.size(); i++){
    if(ans[i]!='0'){
      flag=true;
    }
    if(flag){
      cout<<ans[i];
    }
  }
  }
  else cout<<0;

  return 0;
}