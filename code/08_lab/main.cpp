#include <bits/stdc++.h>

using namespace std;

template<typename T>
class ParametrizedStack {
private:
    vector<T> data;
public:
    ParametrizedStack();

    void push(T);
    T pop();
    T top();
};

template<typename T>
ParametrizedStack<T>::ParametrizedStack() {}

template<typename T>
void ParametrizedStack<T>::push(T element) {
    data.push_back(element);
}

template<typename T>
T ParametrizedStack<T>::pop() {
    return data.pop_back();
}

template<typename T>
T ParametrizedStack<T>::top() {
    return data.back();
}

template<int L, int H>
class MyStack{
private:
    int range;
public:
    
    ParametrizedStack<> *stack;
    MyStack();
};

template<int L, int H>
MyStack<L, H>::MyStack() {
    this->range = H - L + 1;
    if (range <= 256) {
        stack = new ParametrizedStack<char>;
    }
    else if (range <= 65536) {
        stack = new ParametrizedStack<short>;
    }
}

int main() {
    MyStack<1, 50> s;
    return 0;
}