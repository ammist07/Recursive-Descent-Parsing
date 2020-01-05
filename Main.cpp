#include <fstream>
#include <iostream>
#include <string>

using std::endl;
using std::ifstream;
using std::ios;
using std::ofstream;
using std::string;
static int len = 0;
static int i = 0;
static string l ="";

bool A(void);
bool E(void);
bool O(void);
bool P(void);
bool U(void);
bool I(void);
bool C(void);
bool L(void);
bool D(void);

int main(void) {

    ifstream fin("input.txt");
    ofstream fout("output.txt", ios::out | ios::app);

    static string buf;

    while (fin >> buf) {
        len = buf.length();
        l = buf;
        i = 0;
        if(A()){
            fout << "The string \"" + buf + "\" is in the language." << endl;
        }
        else {
            fout << "The string \"" + buf + "\" is not in the language." << endl;
        }
    }
    fout.close();
    fin.close();

    return 0;
}
//A -> I = E
bool A(){
     if( i < len && I()){
            if( i < len && l.at(i++)=='='){
                if( i < len && E()){
                    return true;
                }
                
            }
        }
    return false;
}
//E -> P O P | P
bool E(){
    if(P()){
            if(O()){
                if(P()){
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
}
//O -> + | - | * | / | **
bool O(){
     if( (i < len && ( ( (l.at(i)=='+')) || (i < len && (l.at(i)=='-'))  || (i < len && (l.at(i)=='/')) ) )){
            i++;
            return true;
     }
     if(i < len && l.at(i)=='*'){
            i++;
            if(i < len && l.at(i)=='*'){
                i++;
                return true;
            }
            return true;
        }
    return false;
}
//P -> I | L | UI | UL | (E)
bool P(){
    if(I()){
        return true;
    }
    if(L()){
        return true;
    }
    if(U()){
        if(I()){
            return true;
        }
        if(L()){
            return true;
        }
        return false;
    }
    if(i < len && (l.at(i)=='(')){
        i++;
        if(E()){
            if(i < len && (l.at(i)==')')){
                i++;
                return true;
            }
        }
    }
    return false;
}
//U -> + | - | !
bool U(){
    if(i < len){
            if(l.at(i)=='+' || (l.at(i)=='-') || (l.at(i)=='!')){
                i++;
                return true;
            }
        }
    return false;
}
//I -> C | CI
bool I(){
     if(i < len && C()){
            if(i < len && I()){
                return true;
            }
            return true;
        }
    return false;
}
//C -> a | b | ... | y | z
bool C(){
    if(i < len ){
            if(l.at(i)>='a' && l.at(i)<='z'){
                i++;
                return true;
            }
        }
    return false;
}
//L -> D | DL
bool L(){
    if(i < len && D()){
            if(i < len && L()){
                return true;
            }
            return true;
        }
    return false;
}
//D -> 0 | 1 | ... | 8 | 9 
bool D(){
    if(i < len){
        if(l.at(i)>='0'&&l.at(i)<='9'){
            i++;
            return true;
        }
    }
    return false;
}


