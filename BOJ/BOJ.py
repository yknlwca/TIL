
# while 1:
#     a,b,c= map(int,input().split())
#
#     if a == 0 :
#         break
#     elif a == b == c:
#         print('Equilateral')
#     elif a == b or b == c or c == a:
#         print('Isosceles')
#     elif a + b <= c or b + c <= a or c + a <= b:
#         print('Invalid')
#     else:
#         print('Scalene')





# while 1:
#     n = list(map(int, input().split()))
#
#     if n == [0, 0, 0]:
#         break
#     n.sort()
#     if n[0] + n[1] <= n[2]:
#         print("Invalid")
#     elif n[0] == n[1] == n[2]:
#         print("Equilateral")
#     elif n[0] == n[1] or n[1] == n[2]:
#         print("Isosceles")
#     else:
#         print("Scalene")
#
#
# while 1:
#     A, B = map(int, input().split())
#     if A ==0 and B ==0:
#         break
#
#     if A > B :
#         print('Yes')
#     else:
#         print('No')



# def count_points_after_steps(n):
#     if n == 1:
#         return 9
#     else:
#         return 4 * count_points_after_steps(n - 2)
# n = int(input())
# print(count_points_after_steps(n))

# def jum(n):
#     if n == 1:
#         return 9
#     else:
#         return 4 * jum(n)
#



# grid = [list(map(int, input().split())) for _ in range(9)]
#
# max_value = 0
# max_row = 0
# max_col = 0
#
# for row in range(9):
#     for col in range(9):
#         if grid[row][col] >= max_value:
#             max_value = grid[row][col]
#             max_row = row + 1
#             max_col = col + 1
#
# print(max_value)
# print(max_row, max_col)

# N , M = map(int,input().split())
# A = []
# B = []
# for i in range(N):
#     for j in range(M):
#

# def money(cent):
#     quarter = cent // 25
#     cent %= 25
#     dime = cent // 10
#     cent %= 10
#     nickel = cent // 5
#     penny = cent % 5
#     return quarter, dime, nickel, penny
#
# T = int(input())
#
# for _ in range(T):
#     change = int(input())
#
#     result = money(change)
#     print(*result)


# stu = list(range(1,31))
#
# for _ in range(28):
#     n = int(input())
#     stu.remove(n)
# print(min(stu))
# print(max(stu))


# def cgy(A, B):
#     while B != 0:
#         A,B = B, A%B
#     return A
#
# def cgb(A,B):
#     return (A*B) // cgy(A,B)
#
# T = int(input())
# for _ in range(T):
#     A,B = map(int,input().split())
#     print(cgb(A,B))

# R1 , S = map(int,input().split())
# print((2*S-R1))

# H, M, S = map(int, input().split())
# T = int(input())
# S += T
#
# while S >= 60:
#     M += S // 60
#     S = S % 60
#
# while M >= 60:
#     H += M // 60
#     M = M % 60
#
# while H >= 24:
#     H = H % 24
#
# print(H, M, S)


# A, I = map(int,input().split())
#
# print(round((A * I) - (A - 1)))



# A,B,C = map(int,input().split())
# print((A+B+C)-max(A,B,C)-min(A,B,C))


# A = int(input())
# B = input()
# C = int(input())
#
# if B == '+':
#     print(A+C)
# elif B == '*':
#     print(A*C)


# WS = int(input())
# SH = int(input())
# SG = int(input())
# SY = int(input())
# GS = int(input())
#
# if WS < 40 :
#     WS = 40
# if SH < 40 :
#     SH = 40
# if SG < 40 :
#     SG = 40
# if SY < 40 :
#     SY = 40
# if GS < 40 :
#     GS = 40
#
# print((WS+SH+SG+SY+GS)//5)



#
# T = int(input())
# for _ in range(T):
#     K = input().split()
#     num = float(K[0])
#     for i in range(1,len(K)):
#         if i == '@':
#             num *= 3
#         elif i == '%':
#             num += 5
#         elif i == '#':
#             num -= 7
#         print(num)


# def calculate_expression(expression):
#     result = float(expression[0])
#     for i in range(1, len(expression), 2):
#         operator = expression[i]
#         operand = float(expression[i + 1])
#
#         if operator == '@':
#             result *= 3
#         elif operator == '%':
#             result += 5
#         elif operator == '#':
#             result -= 7
#
#         result = round(result + operand, 2)
#
#     return result
#
# def main():
#     T = int(input())  # 테스트 케이스의 개수
#
#     for _ in range(T):
#         expression = input().split()
#         result = calculate_expression(expression)
#         print(f'{result:.2f}')
#
# if __name__ == "__main__":
#     main()

#
# K,M,N = map(int,input().split())
# snack = K*M
# if N >= snack:
#     print(0)
# elif N < snack:
#     print(snack-N)


# A,B = map(int,input().split())
# print(A+B)


# N = int(input())
# lst = []
# for _ in range(N):
#     T = int(input())
#     lst.append(T)
# if N/2 < sum(lst):
#     print('Junhee is cute!')
# elif N/2 > sum(lst):
#     print('Junhee is not cute!')



# while 1:
#     M, F = map(int, input().split())
#     if M == 0 and F == 0:
#         break
#     print(M+F)


# K = int(input())
# M = input()
# if M.count('A') == M.count('B'):
#     print('Tie')
# elif M.count('A') > M.count('B'):
#     print('A')
# else:
#     print('B')


# def alien_operator(num, operator):
#     if operator == '@':
#         return num * 3
#     elif operator == '%':
#         return num + 5
#     elif operator == '#':
#         return num - 7
# def calculate_alien_expression(expression):
#     num, operators = expression.split(' ')
#     num = float(num)
#     for operator in operators:
#         num = alien_operator(num, operator)
#     return round(num, 2)
# T = int(input())
# for _ in range(T):
#     expression = input()
#     result = calculate_alien_expression(expression)
#     print(f'{result:.2f}')


# T = int(input())
# for _ in range(T):
#     lst = list(input().split())
#     lst[0] = float(lst[0])
#     for i in range(1,len(lst)):
#         if lst[i] == '@':
#             lst[0] *= 3
#         elif lst[i] == '%':
#             lst[0] += 5
#         elif lst[i] == '#':
#             lst[0] -= 7
#     print(f'{lst[0]:.2f}')

# n = int(input())
# chang = 100
# sang = 100
# for _ in range(n):
#     c,s = map(int,input().split())
#     if c > s :
#         sang -= c
#     elif c < s :
#         chang -= s
#     else:
#         continue
# print(chang)
# print(sang)


# N = int(input())
# for _ in range(N):
#     r , e , c = map(int,input().split())
#     if r < e-c:
#         print('advertise')
#     elif r == e-c:
#         print('does not matter')
#     else:
#         print('do not advertise')



# N = int(input())
#
# prizes = []
# for _ in range(N):
#     dice = list(map(int, input().split()))
#     dice.sort()
#
#     if dice[0] == dice[2]:
#         prize = 10000 + dice[0] * 1000
#
#     elif dice[0] == dice[1] or dice[1] == dice[2]:
#         prize = 1000 + dice[1] * 100
#
#     else:
#         prize = dice[2] * 100
#
#     prizes.append(prize)
# print(max(prizes))


# N = int(input())
#
# S = 1000 - N
# k = 0
# while 1:
#     if S // 500 > 0 :
#         k += 1
#         S = S % 500
#     if S // 500 == 0 :
#         break
# while 1:
#     if S // 100 > 0 :
#         k += 1
#         S = S % 100
#     if S // 100 == 0:
#         break
# while 1:
#     if S // 50 > 0 :
#         k += 1
#         S = S % 50
#     if S // 50 == 0:
#         break
# while 1:
#     if S // 10 > 0 :
#         k += 1
#         S = S % 10
#     if S // 10 == 0:
#         break
# while 1:
#     if S // 5 > 0 :
#         k += 1
#         S = S % 5
#     if S // 5 == 0:
#         break
# while 1:
#     if S // 1 > 0 :
#         k += 1
#         S = S % 1
#     if S // 1 == 0:
#         break
# print(k)


# change = [500,100,50,10,5,1]
# money = 1000 - int(input())
# cnt = 0
#
# for c in change:
#     if money >= c:
#         cnt += money // c
#         money %= c
# print(cnt)


# n = int(input())
# Q1 = 0
# Q2 = 0
# Q3 = 0
# Q4 = 0
# AXIS = 0
# for _ in range(n):
#     a,b = map(int,input().split())
#     if a == 0 or b == 0:
#         AXIS += 1
#     elif a > 0 and b > 0 :
#         Q1 += 1
#     elif a > 0 and b < 0 :
#         Q4 += 1
#     elif a < 0 and b > 0 :
#         Q2 += 1
#     elif a < 0 and b < 0 :
#         Q3 += 1
# print(f'Q1: {Q1}')
# print(f'Q2: {Q2}')
# print(f'Q3: {Q3}')
# print(f'Q4: {Q4}')
# print(f'AXIS: {AXIS}')

# while 1:
#     lst = list(map(int,input().split()))
#     lst.sort()
#     if sum(lst) == 0 :
#         break
#
#     if lst[0]**2 + lst[1]**2 == lst[-1]**2:
#         print('right')
#     else:
#         print('wrong')


# T = int(input())
# lst1 = []
# for _ in range(T):
#     lst2 = list(map(int,input().split()))
#     lst1.append(lst2)
# x = [i[0] for i in lst1]
# y = [i[-1] for i in lst1]
#
# print((max(x)-min(x))*(max(y)-min(y)))



# 두변의 길이의 합이 나머지 한변의 길이보다 커야한다.
# 두변의 길이 합이 나머지 한변 길이 보다 작
# lst = list(map(int,input().split()))
# lst.sort()
# if lst[-1] <= lst[0]+lst[1]:
#     print(sum(lst))
# else:
#     lst[-1] = lst[0] + lst[1] -1
#     print(sum(lst))


# t = input()
# l = 10
# for i in range(len(t)-1):
#     if t[i+1] == t[i]:
#         l += 5
#     elif t[i+1] != t[i]:
#         l += 10
# print(l)


# t = int(input())
#
# for _ in range(t):
#     p = int(input())
#
#     max_price = 0
#     max_player = ""
#
#     for _ in range(p):
#         price, player = input().split()
#         price = int(price)
#
#         if price > max_price:
#             max_price = price
#             max_player = player
#
#     print(max_player)

# lst = []
# a = 0
# for _ in range(5):
#     b = int(input())
#     a += b
#     lst.append(b)
#     lst.sort()
# print(a // 5)
# print(lst[2])


# import math

#
# def find_min_sum_of_squares(m, n):
#     min_square = float('inf')
#     sum_of_squares = 0
#     has_square = False
#
#     for i in range(m, n + 1):
#         square_root = int(math.sqrt(i))
#         if square_root ** 2 == i:
#             has_square = True
#             min_square = min(min_square, i)
#             sum_of_squares += i
#
#     if not has_square:
#         return -1, -1
#     else:
#         return sum_of_squares, min_square
#
#
# m = int(input())
# n = int(input())
#
# sum_of_squares, min_square = find_min_sum_of_squares(m, n)
# print(sum_of_squares)
# print(min_square)



# import math
#
# M = int(input())
# N = int(input())
# lst = []
#
# for i in range(M, N+1):
#     if int(math.sqrt(i))**2 == i:
#         lst.append(i)
#
# if not lst:
#     print(-1)
# else:
#     print(sum(lst))
#     print(lst[0])


# from datetime import datetime
#
# def find_age_range(students):
#     youngest = float('inf')
#     oldest = 0
#     youngest_name = ""
#     oldest_name = ""
#
#     for student in students:
#         name, day, month, year = student.split()
#         birthday = datetime(int(year), int(month), int(day))
#         age = (datetime.now() - birthday).days // 365
#
#         if age < youngest:
#             youngest = age
#             youngest_name = name
#
#         if age > oldest:
#             oldest = age
#             oldest_name = name
#
#     return youngest_name, oldest_name
#
# # 입력 받기
# n = int(input())
# student_list = [input() for _ in range(n)]
#
# # 결과 출력
# youngest, oldest = find_age_range(student_list)
# print(youngest)
# print(oldest)



# def fibonacci(n):
#     fib = [0, 1]
#
#     for i in range(2, n + 1):
#         fib.append(fib[i - 1] + fib[i - 2])
#
#     return fib[n]
#
# n = int(input())
#
# result = fibonacci(n)
# print(result)


# N = int(input())
# for i in range(N,0,-1):
#     print(i)

# T = int(input())
# e = 0
# k = 0
# for _ in range(T):
#     N = int(input())
#     for _ in range(N):
#         a ,b = input().split()
#         c = int(a)
#         d = float(b)
#         e += c
#         k += (c*d)
# print(k/e)


# N,M = map(int,input().split())
# lst = list(map(int,input().split()))



# from itertools import combinations
#
# def find_nearest_sum(cards, target):
#     closest_sum = 0
#
#     for combination in combinations(cards, 3):
#         current_sum = sum(combination)
#
#         if current_sum == target:
#             return current_sum
#
#         if closest_sum < current_sum <= target:
#             closest_sum = current_sum
#
#     return closest_sum
#
# # 입력 받기
# N, M = map(int, input().split())
# cards = list(map(int, input().split()))
#
# # 결과 출력
# result = find_nearest_sum(cards, M)
# print(result)

# T = int(input())
# for _ in range(T):
#     s = int(input())
#     k = int(input())
#     for _ in range(k):
#         a,b = map(int,input().split())
#         s += a*b
#     print(s)


# N = int(input())
# a = 1
# for i in range(1,N+1):
#     a *= i
# print(a)

# a = int(input())
# lst = list(map(int,input().split()))
# cnt = 0
#
# for i in lst:
#     if i == a:
#         cnt += 1
# print(cnt)


# T = int(input())
# for _ in range(T):
#     N = int(input())
#     lst = list(map(int,input().split()))
#     print(sum(lst))

# lst = []
# a = 0
# for _ in range(7):
#     N = int(input())
#     if N % 2 == 1:
#         lst.append(N)
#         a += N
# if a == 0:
#     print(-1)
# else:
#     print(a)
#     lst.sort()
#     print(lst[0])



# def fibo(n):
#     fib = [0, 1]
#
#     for i in range(2, n + 1):
#         fib.append(fib[i - 1] + fib[i - 2])
#
#     return fib[n]
#
# n = int(input())
# print(fibo(n))


# A,B = map(int,input().split())
#
# C = []
# if A == 1 and B == 1:
#     print(1)
# else:
#     for i in range(B):
#         if i == 0 :
#             pass
#         else:
#             for j in range(i):
#                 C.append(i)
#     print(sum(C[A-1:B]))

# T = int(input())
# for _ in range(T):
#     lst = list(map(int,input().split()))
#     lst.sort()
#     print(lst[-3])

# a,b = map(int,input().split())
#
# lst = []
# for i in range(1,max(a,b)+1):
#     if a % i == 0 and b % i ==0:
#         lst.append(i)
# k = (a*b) // lst[-1]
#
# print(lst[-1])
# print(k)


# N = int(input())
# lst = []
# for _ in range(N):
#     a = int(input())
#     lst.append(a)
# lst.sort()
# for i in lst:
#     print(i)

# K = int(input())
# lst = []
# for _ in range(K):
#     a = int(input())
#     if a != 0:
#         lst.append(a)
#     elif a == 0 :
#         lst.pop()
# print(sum(lst))


# N = int(input())
# members = []
#
# for i in range(N):
#     age, name = input().split()
#     members.append((int(age), name, i))
#
# members.sort(key=lambda x: (x[0], x[2]))
#
# for member in members:
#     print(member[0], member[1])

# a, b = input().split()
# a = a[::-1]
# b = b[::-1]
# a = int(a)
# b = int(b)
# result = str(a+b)
# print(int(result[::-1]))


#
# T = int(input())
# for x in range(T):
#     print(f'Class {x+1}')
#     lst = []
#     lst1 = []
#     lst = list(map(int , input().split()))
#     lst.remove(lst[0])
#     lst.sort()
#     for i in range(len(lst)-1):
#         k = lst[i+1] - lst[i]
#         lst1.append(k)
#     print(f'Max {max(lst)}, Min {min(lst)}, Largest gap {max(lst1)}')

# 퀵 정렬 공부하기
# N = int(input())
# lst = []
# for _ in range(N):
#     a = int(input())
#     lst.append(a)
#     lst.sort()
# for i in lst:
#     print(i)

# while 1:
#     N = input()
#     if N == 'END':
#         break
#     print(N[::-1])


# N = int(input())
# lst = []
# for _ in range(N):
#     a = int(input())
#     lst.append(a)
#     lst.sort()
# for i in lst:
#     print(i)

# N = int(input())
# k = N // 5
# m = (N-(k*5))
# if m % 3 == 0 :
#     print(k+(m//3))
# elif m % 3 != 0 :
#     print(-1)


# scores = [list(map(int, input().split())) for _ in range(5)]
#
#
# total_scores = [sum(score) for score in scores]
#
#
# winner = total_scores.index(max(total_scores)) + 1
# max_score = max(total_scores)
#
# print(winner, max_score)


# lst = [1,5,5,7,8]
# print(sum(lst))
# lst.sort()
# print(lst)
# print(sum(lst[1:-1]))
# print(len(lst[1:-1]))


# N = int(input())
#
# def banal(value):
#     inter = int(value)
#     jung = value - inter
#     if jung >= 0.5:
#         return inter + 1
#     else:
#         return inter
#
# if N == 0 :
#     print(0)
# else:
#     zelsa = banal(N*0.15)
#     lst = []
#     for _ in range(N):
#         a = int(input())
#         lst.append(a)
#         lst.sort()
#         zelav = lst[zelsa:-zelsa]
#     print(banal((sum(zelav)/len(zelav))))




# max_passenger = 0
# current_passenger = 0
#
# for _ in range(10):
#     out, in_ = map(int, input().split())
#     current_passenger = current_passenger - out + in_
#     max_passenger = max(max_passenger, current_passenger)
#
# print(max_passenger)



# A = input()
# b = A.split('-')
# for i in range(len(b)):
#     print(b[i][0], end = '')


# n = int(input())
# for _ in range(n):
#     a,b = input().split()
#     a = int(a)
#     print(b[:a-1]+b[a:])


# def find_max_two_friends(N, friendships):
#     def find_friends(person):
#         direct_friends = {i for i in range(N) if friendships[person][i] == 'Y'}
#         indirect_friends = set()
#         for friend in direct_friends:
#             indirect_friends |= {i for i in range(N) if friendships[friend][i] == 'Y'}
#         return (direct_friends | indirect_friends) - {person}
#
#     max_two_friends = 0
#     for person in range(N):
#         max_two_friends = max(max_two_friends, len(find_friends(person)))
#
#     return max_two_friends
#
# N = int(input())
# friendships = []
# for _ in range(N):
#     friendships.append(input())
#
# print(find_max_two_friends(N, friendships))

# lst = []
# for i in range(8):
#     score = int(input())
#     lst.append((score, i+1))
# lst.sort(reverse=True)
# top_scores = lst[:5]
# total = sum(score for score, _ in top_scores)
# numbers = sorted(problem for _, problem in top_scores)
# print(total)
# for j in numbers:
#     print(j, end=' ')

# N,M = map(int,input().split())
# lst = list(map(int,input().split()))
# ans = 0
# lst.sort()
# for i in range(len(lst)-2):
#     for j in range(i+1,len(lst)-1):
#         for k in range(j+1,len(lst)):
#             if M >= lst[i]+lst[j]+lst[k] and (lst[i]+lst[j]+lst[k]) - ans > 0 :
#                 ans = lst[i] + lst[j] + lst[k]
# print(ans)

# import sys
#
# N = int(sys.stdin.readline())
# lst = []
# for _ in range(N):
#     a = int(sys.stdin.readline())
#     lst.append(a)
# lst.sort()
# for i in lst:
#     sys.stdout.write(i)

# import sys
# N = int(sys.stdin.readline())
# lst = []
# for _ in range(N):
#     lst.append(int(sys.stdin.readline()))
# lst.sort()
# print(round(sum(lst)/len(lst)))
# print(lst[len(lst)//2])
#
# count_dict = {}
# max_count = 0
# for num in lst:
#     if num in count_dict:
#         count_dict[num] += 1
#     else:
#         count_dict[num] = 1
#     if count_dict[num] > max_count:
#         max_count = count_dict[num]
#
# mode = [key for key, value in count_dict.items() if value == max_count]
#
# print(mode[1] if len(mode) > 1 else mode[0])
# print(max(lst)-min(lst))



# N = int(input())
# A = list(map(int, input().split()))
# M = int(input())
# isin = list(map(int, input().split()))
#
# A = set(A)
# result = []
#
# for i in isin:
#     if i in A:
#         result.append(1)
#     else:
#         result.append(0)
#
# for j in result:
#     print(j)


# N = input()
# tennum = int(N,16)
# print(tennum)


# N = int(input())
# cnt = 0
#
# if N // 5 > 0 :
#     cnt += N//5
#     cnt += (N%5)//3
#     print(cnt)


# N = int(input())
# cnt = -1
#
# value, extra = divmod(N, 5)
#
# if extra == 0:
#     cnt = value
# else:
#     while value >= 0:
#         if extra % 3 == 0:
#             cnt = value + (extra // 3)
#             break
#         else:
#             value -= 1
#             extra += 5
# print(cnt)


# N = int(input())
# lst1 = list(map(int,input().split()))
# M = int(input())
# lst2 = list(map(int,input().split()))
# cnt = 0
# for i in range(M):
#     if lst2[i] in lst1:
#        cnt += 1
# print(cnt)
#¡
# n = int(input())
# for i in range(n):
#     print(' '* i + '*'* (n-i))


# n = int(input())
# arr = [int(input()) for _ in range(n)]
# arr.sort()
# for i in range(arr):
#     print(i)


# N = int(input())
# lst = [int(input()) for _ in range(N)]
# lst.sort()
# for i in lst:
#     print(i)


# import sys
# input = sys.stdin.readline
# print = sys.stdout.write
#
# n = int(input())
# sortlist = [0]*10001
#
# for i in range(n):
#     sortlist[int(input())] += 1
#
# for i in range(1,10001):
#     for j in range(sortlist[i]):
#         print(str(i) + '\n')


# n = int(input())
# point = [list(map(int,input().split())) for _ in range(n)]
# point.sort()
# for x in point:
#     print(' '.join(map(str,x)))

# n = int(input())
# point = [list(map(int,input().split())) for _ in range(n)]
#
# point.sort(key= lambda x:(x[1],x[0]))
#
# for x in point:
#     print(' '.join(map(str,x)))


# lst = list(map(int,input().split()))
# lst.sort()
# for i in lst:
#     print(i, end = ' ')

#
# def find():
#
#     oldest = youngest = students[0]
#     for name, day, month, year in students[1:]:
#         current_birthday = (year, month, day)
#         oldest_birthday = (oldest[3], oldest[2], oldest[1])
#         youngest_birthday = (youngest[3], youngest[2], youngest[1])
#
#         if current_birthday < oldest_birthday:
#             oldest = (name, day, month, year)
#
#         if current_birthday > youngest_birthday:
#             youngest = (name, day, month, year)
#
#
# n = int(input())
# students = []
# for _ in range(n):
#     name, day, month, year = input().split()
#     students.append((name, int(day), int(month), int(year)))
#
# print(oldest[0])
# print(youngest[0])


# N = int(input())
#
# for _ in range(N):
#     lst = list(map(int,input().split()))
#     lst.sort()
#     jumsu = lst[1:-1]
#     if jumsu[-1] - jumsu[0] >= 4 :
#         print('KIN')
#     else:
#         print(sum(jumsu))



# s = input().split(',')
# for i in s:
#     int(i)
# print(len(s))


# a, b, s = map(int,input().split())
# x = a + b
# y = a + b
# while 1:
#     x += b
#     y += a
#     if x == s or y == s :
#         print('YES')
#     elif x > s or y > s :
#         break
#     else:
#         print('NO')


# 2003번
# 문제
# N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다. 이 수열의 i번째 수부터 j번째 수까지의 합
# A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 N(1 ≤ N ≤ 10,000), M(1 ≤ M ≤ 300,000,000)이 주어진다.
# 다음 줄에는 A[1], A[2], …, A[N]이 공백으로 분리되어 주어진다. 각각의 A[x]는 30,000을 넘지 않는 자연수이다.

# 출력
# 첫째 줄에 경우의 수를 출력한다.
#
# 예제 입력 1
# 4 2
# 1 1 1 1
# 예제 출력 1
# 3
# 예제 입력 2
# 10 5
# 1 2 3 4 2 5 3 1 1 2
# 예제 출력 2
# 3


































































































































































































































































