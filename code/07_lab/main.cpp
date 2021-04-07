#include <bits/stdc++.h>

using namespace std;

/*
Система материальных точек, каждая из
которых определяется своими координатами на
плоскости и массой, с операциями:

1. получение количества точек в системе;

2. получение ссылки на i-тую точку;

3. вычисление центра масс системы;

4. добавление новой точки;

5. удаление точек с нулевой массой;

Для представления материальной точки следует
разработать отдельный класс.
*/

const double EPS = 10e-9;

class Point {
private:
    double x, y;
    double mass;
public:
    double get_x();
    double get_y();
    double get_mass();
    Point(double, double);
    Point();

    void input_point();
    void display_point();
};

Point::Point(double x, double y) {
    this->x = x;
    this->y = y;
}

Point::Point() {
    this->x = 0.0;
    this->y = 0.0;
}

double Point::get_x() {
    return this->x;
}

double Point::get_y() {
    return this->y;
}

double Point::get_mass() {
    return this->mass;
}

void Point::input_point() {
    double x, y, mass;
    cin >> x >> y >> mass;
    this->x = x, this->y = y, this->mass = mass;
}

void Point::display_point() {
    cout << "x: " << this->x << " y: " << this->y << " mass: " << this->mass << "\n";
}

class MaterialPoints {
private:
    Point *points;
    uint32_t amount;
    uint32_t capacity;
    
    void reinitialize(uint32_t);
    void shift(uint32_t);

    const uint32_t BASIC_AMOUNT = 0;
    const uint32_t BASIC_CAPACITY = 2;
public:
    MaterialPoints();
    ~MaterialPoints();

    uint32_t get_amount();
    uint32_t get_capacity();
    void input_points(uint32_t);
    void push_back(Point);
    Point &at(uint32_t);
    pair<double, double> get_mass_center();
    void delete_all_zero_mass();
    
    void display();
};

MaterialPoints::MaterialPoints() {
    this->amount = BASIC_AMOUNT;
    this->capacity = BASIC_CAPACITY;
    this->points = new Point[this->capacity];
}

MaterialPoints::~MaterialPoints() {
    delete[] points;
}

uint32_t MaterialPoints::get_amount() {
    return this->amount;
}

uint32_t MaterialPoints::get_capacity() {
    return this->capacity;
}

void MaterialPoints::input_points(uint32_t amount) {
    for (uint32_t i = 0; i < amount; ++i) {
        points[i].input_point();
    }
}

void MaterialPoints::reinitialize(uint32_t new_capacity) {
    Point *holder = new Point[new_capacity];
    for (uint32_t i = 0; i < this->amount; ++i) {
        holder[i] = this->points[i];
    }
 
    delete [] points;
    points = new Point[new_capacity];

    for (uint32_t i = 0; i < this->amount; ++i) {
        points[i] = holder[i];
    }

    this->capacity = new_capacity;
}

void MaterialPoints::shift(uint32_t start) {
    for (uint32_t i = start; i < amount - 1; ++i) {
        points[i] = points[i + 1];
    }
    amount--;
}

void MaterialPoints::push_back(Point p) {
    if (amount + 1 == capacity) {
        reinitialize(capacity * 2);
    }
    points[amount++] = p;
}

Point &MaterialPoints::at(uint32_t i) {
    //assert(i < this->amount);
    return points[i];
}

pair<double, double> MaterialPoints::get_mass_center() {
    double x_r = 0.0, y_r = 0.0, mass_summary = 0.0;
    for (uint32_t i = 0; i < this->amount; ++i) {
        x_r += points[i].get_mass() * points[i].get_x();
        y_r += points[i].get_mass() * points[i].get_y();
        mass_summary += points[i].get_mass();
    }
    x_r /= mass_summary;
    y_r /= mass_summary;
    return pair<double, double>(x_r, y_r);
}

void MaterialPoints::delete_all_zero_mass() {
    for (uint32_t i = 0; i < amount;) {
        if (points[i].get_mass() == 0.0) {
            shift(i);
        }
        else {
            ++i;
        }
    }
    if (amount < capacity / 2) {
        capacity / 2 == 0 ? reinitialize(1) : reinitialize(capacity / 2);
    }
}

void MaterialPoints::display() {
    for (uint32_t i = 0; i < amount; ++i) {
        points[i].display_point();
    }
}

int main() {
    MaterialPoints m;
    //m.input_points(5);

    uint32_t req;
    cin >> req;
    while(req--) {
        uint32_t type;
        cin >> type;
        //cerr << m.get_amount() << " " << m.get_capacity() << "\n";
        if (type == 1) {
            Point x;
            x.input_point();
            m.push_back(x);
        }
        else if (type == 2) {
            m.display();
        }
        else if (type == 3) {
            m.delete_all_zero_mass();
        }
        else if (type == 4) {
            pair<double, double> mc = m.get_mass_center();
            cout << mc.first << " " << mc.second << "\n";
        }
        else if (type == 5) {
            uint32_t ix;
            cin >> ix;
            m.at(ix).display_point();
        }
    }
    delete &m;
    return 0;
}