#include <bits/stdc++.h>

using namespace std;

const int l1 = 1;
const int h1 = 50;

const int l2 = 1;
const int h2 = 65535;

const int l3 = 1;
const int h3 = 1e9;

template<typename T>
class ParametrizedStack {
private:
    vector<T> data;
public:
    ParametrizedStack();

    void push(T);
    void pop();
    T top();
    void display();
};

template<typename T>
ParametrizedStack<T>::ParametrizedStack() {}

template<typename T>
void ParametrizedStack<T>::push(T element) {
    data.push_back(element);
}

template<typename T>
void ParametrizedStack<T>::pop() {
    if (data.size() > 0) data.pop_back();
}

template<typename T>
T ParametrizedStack<T>::top() {
    return data.back();
}

template<typename T>
void ParametrizedStack<T>::display() {
    for (T element : data) {
        cout << element << " ";
    }
    cout << "\n";
}

template<int L, int H>
class MyStack{
private:
    int range;
    
public:
    bool is_char;
    bool is_short;
    bool is_int;

    ParametrizedStack<char> stack_char;
    ParametrizedStack<short> stack_short;
    ParametrizedStack<int> stack_int;
    MyStack();
};

template<int L, int H>
MyStack<L, H>::MyStack() {
    this->range = H - L + 1;
    if (range <= 256) is_char = true;
    else if (range <= 65536 && range > 256) is_short = true;
    else is_int = true;
}

int main() {
    MyStack<l1, h1> stack;
    //cout << stack.is_char << " " << stack.is_short << " " << stack.is_int << "\n";
    int req;
    cin >> req;
    while (req--) {
        int type;
        cin >> type;
        if (type == 1) {
            if (stack.is_char) {
                char x;
                cin >> x;
                stack.stack_char.push(x);
            }
            else if (stack.is_short) {
                short x;
                cin >> x;
                stack.stack_short.push(x);
            }
            else if (stack.is_int) {
                int x;
                cin >> x;
                stack.stack_int.push(x);
            }
        }
        else if (type == 2) {
            if (stack.is_char) {
                stack.stack_char.pop();
            }
            else if (stack.is_short) {
                stack.stack_short.pop();
            }
            else if (stack.is_int) {
                stack.stack_int.pop();
            }
        }
        else if (type == 3) {
            if (stack.is_char) {
                cout << stack.stack_char.top() << "\n";
            }
            else if (stack.is_short) {
                cout << stack.stack_short.top() << "\n";
            }
            else if (stack.is_int) {
                cout << stack.stack_int.top() << "\n";
            }
        }
        else if (type == 4) {
            if (stack.is_char) {
                stack.stack_char.display();
            }
            else if (stack.is_short) {
                stack.stack_short.display();
            }
            else if (stack.is_int) {
                stack.stack_int.display();
            }
        }
    }
    return 0;
}