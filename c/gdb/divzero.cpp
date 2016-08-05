#include <iostream>
using namespace std;
bool IsUnique()
{
        int k = 0, m = 0;
        k = k/m;      //这里会crash
        return true;
}
int main()
{
        cout << IsUnique() << endl;
        return 0;
}
