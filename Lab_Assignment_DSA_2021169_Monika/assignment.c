#include <stdio.h>
#include <stdlib.h>
#define MAX_TREE_HT 100
char gh[1000000];
int  st[1000][1000];
int qw[10000];
int x=0;
// Huffman tree node
struct MinHeap__Node {
    unsigned freq;
    char data;
    struct MinHeap__Node *left, *right;
};
 
struct MinHeap_ {
    unsigned amount;
    unsigned size;
    struct MinHeap__Node** array;
};
 
struct MinHeap__Node* newNode(char data, unsigned freq){
    struct MinHeap__Node* temp = (struct MinHeap__Node*)malloc(
        sizeof(struct MinHeap__Node));
    temp->freq = freq;
    temp->left = temp->right = NULL;
    temp->data = data;
    return temp;
}
struct MinHeap_* createMinHeap(unsigned amount){
    struct MinHeap_* minHeap= (struct MinHeap_*)malloc(sizeof(struct MinHeap_));
    minHeap->amount = amount;
    minHeap->size = 0;
    minHeap->array = (struct MinHeap__Node**)malloc(minHeap->amount * sizeof(struct MinHeap__Node*));
    return minHeap;
}
 
// swap two min heap 
void swapMin_HeapNode(struct MinHeap__Node** a,struct MinHeap__Node** b){
    struct MinHeap__Node* t = *a;
    *a = *b;
    *b = t;
}

void minHeapify(struct MinHeap_* minHeap, int idx){
    int small = idx;
    int left = 2 * idx + 1;
    int right = 2 * idx + 2;
 
    if (left < minHeap->size && minHeap->array[left]->freq < minHeap->array[small]->freq)
        small = left;
 
    if (right < minHeap->size && minHeap->array[right]->freq < minHeap->array[small]->freq)
        small = right;
 
    if (small != idx) {
        swapMin_HeapNode(&minHeap->array[small],&minHeap->array[idx]);
        minHeapify(minHeap, small);
    }
}

int is_Size_One(struct MinHeap_* minHeap){
    return (minHeap->size == 1);
}
 
struct MinHeap__Node* extract_Min(struct MinHeap_* minHeap){
    struct MinHeap__Node* temp = minHeap->array[0];
    minHeap->array[0] = minHeap->array[minHeap->size - 1];
    --minHeap->size;
    minHeapify(minHeap, 0);
    return temp;
}

void insertMinHeap(struct MinHeap_* minHeap,struct MinHeap__Node* minHeapNode){
    ++minHeap->size;
    int i = minHeap->size - 1;
    while (i && minHeapNode->freq < minHeap->array[(i - 1) / 2]->freq) {
 
        minHeap->array[i] = minHeap->array[(i - 1) / 2];
        i = (i - 1) / 2;
    }
    minHeap->array[i] = minHeapNode;
}
 
// function to build min heap
void build_Min_Heap(struct MinHeap_* minHeap){
    int n = minHeap->size - 1;
    int i;
    for (i = (n - 1) / 2; i >= 0; --i)
        minHeapify(minHeap, i);
}

int isLeaf(struct MinHeap__Node* root){
    return !(root->left) && !(root->right);
}

struct MinHeap_* createAndBuildMinHeap(char data[],int freq[], int size){
    struct MinHeap_* minHeap = createMinHeap(size);
    for (int i = 0; i < size; ++i)
        minHeap->array[i] = newNode(data[i], freq[i]);
 
    minHeap->size = size;
    build_Min_Heap(minHeap);
    return minHeap;
}
void printArr(int arr[], int n, char c,int size){
    st[x][0]=c;
    qw[x]=n;
    x++;
    int i,m;
    for(int h=0;h<=size;h++){
        if(st[h][0]==c){
            m=h;
            break;
        }
    }
    int y=1;
    for (int a = 0; a < n; ++a){
        printf("%d", arr[a]);
    }
    
    for (i = 0; i < n; ++i){
        st[m][y]=arr[i];
        st[m][y+1]='\0';
        // printf("st is %d",st[m][y]);
        y++;}
    printf("\n");
}
 
struct MinHeap__Node* build_Huffman_Tree(char data[],int freq[], int size){
    struct MinHeap__Node *left, *right, *top;
    struct MinHeap_* minHeap= createAndBuildMinHeap(data, freq, size);
    while (!is_Size_One(minHeap)) {
        left = extract_Min(minHeap);
        right = extract_Min(minHeap);
        top = newNode('$', left->freq + right->freq);
        top->left = left;
        top->right = right;
        insertMinHeap(minHeap, top);
    }
    return extract_Min(minHeap);
}

void printCodes(struct MinHeap__Node* root, int arr[],int top,int size){
    if (root->left) {
        arr[top] = 0;
        printCodes(root->left, arr, top + 1,size);
    }
    if (root->right) {
        arr[top] = 1;
        printCodes(root->right, arr, top + 1,size);
    }
    if (isLeaf(root)) {
        printf("%c -> ", root->data);
        printArr(arr, top,root->data,size);
     
    }
}

void Huffman_Code(char data[], int freq[], int size){
    struct MinHeap__Node* root= build_Huffman_Tree(data, freq, size);
    int arr[MAX_TREE_HT], top = 0;
    printCodes(root, arr, top,size);
}
int main() {
    FILE *fp;
    char file_name[50];
    char out_name[50];
    int mode;
    FILE *fpp;
    char chh;
    char ch;
    char ch_;

    int y=0;
    printf("Enter the name of input file\n");
    scanf("%[^\n]%*c",file_name);
    printf("Enter the name of output file\n");
    scanf("%[^\n]%*c",out_name);
    printf("Enter mode (0 for compression, 1 for decompression)\n");
    scanf("%d",&mode);
    if(mode==1){
        printf("Generating ");
        printf( "%s",out_name);
        return 0;
    }

    if(mode==0){
    fp= fopen (file_name, "r");
    ch = getc(fp);
    gh[0]=ch;
    int p=0;
    while( (ch = getc(fp)) != EOF) {
        for(int k=0; k<p+1;k++){
            if(gh[k] != ch){
                if(k==p){
                    gh[p+1]=ch;
                    p++;
                }
            }
        }

    }
        gh[p+1]='\0';

        fclose(fp);
    


    int arr[p];
    int arr_[p];
    int h=0;
    int g=0;
    int r=0;
    
    while(g<p+1){
        fp= fopen (file_name, "r");
        int count=0;
        while( (chh = getc(fp)) != EOF){
            
            if(gh[h]==chh){
                count++;

            }
            else{
                continue;
            }
        }
     
        arr[r]=count;
        h++;
        r++;
        g++;
        
    }
    
    fclose(fp);
    Huffman_Code(gh, arr, p+1);
    int sum=0;
    for(int t=0;t<p+1;t++){
        sum+=arr[t];
    }
     fpp  = fopen (out_name, "a");
    for(int l=0;l<p+1;l++){
        fprintf(fpp,"%c  ",st[l][0]);
        for(int m=1;m<=qw[l];m++){
            fprintf(fpp,"%d",st[l][m]);
        }
        fprintf(fpp,"\n");
    }
    fprintf(fpp,"\n");
    fp= fopen (file_name, "r");
    while( (ch_ = getc(fp)) != EOF){
            for(int l=0;l<p+1;l++){
                if(st[l][0]==ch_){
                    for(int m=1;m<=qw[l];m++){
                       fprintf(fpp,"%d",st[l][m]);
                    }
                }
                else{
                    continue;
                }
        
    }
    }
        fclose(fpp);
        fclose(fp);
        return 0;

    }
   
    else{
        printf("wrong mode");
        return 0;

    }
    return 0;


}