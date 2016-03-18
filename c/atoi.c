#include <stdio.h>
#include <string.h>
#include <string>


int my_atoi(char* pstr)  
{  
    int Ret_Integer = 0;  
    int Integer_sign = 1;  
      
    /* 
    * 判断指针是否为空 
    */  
    if(pstr == NULL)  
    {  
        printf("Pointer is NULL\n");  
        return 0;  
    }

#if 0
    /* 
    * 跳过前面的空格字符 
    */  
    while(isspace(*pstr) == 0)  
    {  
        pstr++;  
    }  
      
    /* 
    * 判断正负号 
    * 如果是正号，指针指向下一个字符 
    * 如果是符号，把符号标记为Integer_sign置-1，然后再把指针指向下一个字符 
    */  
    if(*pstr == '-')  
    {  
        Integer_sign = -1;  
    }  
    if(*pstr == '-' || *pstr == '+')  
    {  
        pstr++;  
    }  
#endif

    /* 
    * 把数字字符串逐个转换成整数，并把最后转换好的整数赋给Ret_Integer 
    */  
    while(*pstr >= '0' && *pstr <= '9')  
    {  
        Ret_Integer = Ret_Integer * 10 + *pstr - '0';  
        pstr++;  
    }  
    //Ret_Integer = Integer_sign * Ret_Integer;  
      
    return Ret_Integer;  
}

void intersection(int *a, int *b, int sizea, int sizeb) {
    printf("sizeof(aa)=%d, sizeof(bb)=%d\n", sizea, sizeb);

    int c[100] = {0};
    for(int i=0; i<100; i++) {
        if (i > 0 && i % 10 == 0) {
            printf("\n");
        }
        printf("%d ", c[i]);
    }
    for (int i=0; i<sizeb; i++) {
        c[b[i]] = 1;
    }
    for (int i=0; i<sizea; i++) {
        if (c[a[i]] == 1) continue;
        printf("\ndifferent: %d\n", a[i]);
    }
}

static unsigned int hash1( const char *key )
{
    unsigned int len = strlen(key);
    unsigned int res = len;
    for( unsigned int i=0; i<len; i++ )
        res = key[i] | res<<3;
    return res;
}


static unsigned int hash( const std::string &key )
{
    unsigned int res = key.length();
    for( unsigned int i=0; i<key.length(); i++ )
        //res = key[i] | res<<3;
        res = res * 33 + key[i];
    return res;
}


int main()  
{  
//----------------atoi-------------------
    //char a[] = "-100";  
    char b[] = "456";  
    int c = 0;
  
    //c = atoi(a) + atoi(b);  
      
    //printf("atoi(a)=%d\n",atoi(a));  
    //printf("atoi(b)=%d\n",atoi(b));  
    //printf("c = %d\n",c);  
  
//----------------intersect-------------------
    int aa[] = {10, 12, 98, 29, 15, 36, 76, 55, 26, 88};
    int bb[] = {10, 12, 98, 29, 15, 36, 55, 26, 88};
    //intersection(aa, bb, sizeof(aa)/sizeof(int), sizeof(bb)/sizeof(int));


//----------------hash-------------------
    for (int i=0; i<64; i++) {
        //const char *url = "http://www.sina.com.cn/";
        std::string url = "http://www.cnblogs.com/happyday56/p/4009406.html";
        url += std::to_string(i);
        unsigned int hval = hash(url);
        printf("url: %s, hval: %d, %d\n", url.c_str(), hval, hval & 63);    
    }

    return 0;
}
