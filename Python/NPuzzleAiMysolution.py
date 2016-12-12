#Sai Manikanta. GOdavarthi
#WSU ID: J989E647
#Artificial Intelligence Programming Assignment-1
#N-Puzzle problem
#Fixed goal state

import copy
from sets import Set

def grid_matrix(n):
    g = []
    count = 1
    for i in range(0, n):
        g.append([])
        for j in range(0, n):
            g[i].append(count)
            count += 1

    g[n-1][n-1] = 0

    result = []
    for r in g:
        result.append(tuple(r))
    return tuple(result)


def result_value(g):
    for l in g:
        print l
    print


def match_level(g, level):
    for i in range(len(g)):
        for j in range(len(g[i])):
            level -= 1
            if g[i][j] != result_matrix[i][j]:
                return False
            elif i == len(g) - 2 and g[i+1][j] != result_matrix[i+1][j]:
                return False
            elif level == 0:
                return True


def get_banned_moves(g, level):
    """ When a tile is in place dont F* with it """
    result = []
    size = len(g)

    for i in range(len(g)):
        for j in range(len(g[i])):
            if level == 0:
                break
            result.append((i, j))
            level -= 1

    if len(result) % size == size - 1:
        result.pop()

    return result


def duplicate_tuple(g, x1, y1, x2, y2):
    result = []
    for i in range(len(g)):
        r = []
        for j in range(len(g[i])):
            if i == x1 and j == y1:
                r.append(g[x2][y2])
            elif i == x2 and j == y2:
                r.append(g[x1][y1])
            else:
                r.append(g[i][j])
        result.append(tuple(r))
    return tuple(result)


def find_zero(g):
    for i in range(len(g)):
        for j in range(len(g[i])):
            if g[i][j] == 0:
                return (i, j)
    raise Exception('no 0')


def legal_moves(g):
    result = []
    size = len(g) - 1
    zx, zy = find_zero(g)

    if zx > 0 and (zx-1, zy) not in banned_moves:
        new_g = duplicate_tuple(g, zx, zy, zx-1, zy)
        result.append(new_g)
    if zx < size and (zx+1, zy) not in banned_moves:
        new_g = duplicate_tuple(g, zx, zy, zx+1, zy)
        result.append(new_g)
    if zy > 0 and (zx, zy-1) not in banned_moves:
        new_g = duplicate_tuple(g, zx, zy-1, zx, zy)
        result.append(new_g)
    if zy < size and (zx, zy+1) not in banned_moves:
        new_g = duplicate_tuple(g, zx, zy+1, zx, zy)
        result.append(new_g)

    return result


def bf_search(grid, level):
    states_we_have_seen_before = Set(grid)
    current_states = [grid]
    result = None
    counter = 0

    while result is None:
        next_states = Set()

        for g in current_states:
            for gg in legal_moves(g):
                if gg not in states_we_have_seen_before:
                    states_we_have_seen_before.add(gg)
                    next_states.add(gg)

        for t in next_states:
            if match_level(t, level):
                result = t
                break

        current_states = next_states
        counter += 1

    return (counter, result)


def df_search(grid, level):
    states_we_have_seen_before = Set(grid)

    def recur(inner_grid, itter, level):
        counter = 0
        next_states = Set()

        for gg in legal_moves(inner_grid):
            if gg not in states_we_have_seen_before:
                states_we_have_seen_before.add(gg)
                next_states.add(gg)

        for t in next_states:
            if match_level(t, level):
                return (size * size * size - itter, t)

        if itter > 0:
            for t in next_states:
                r = recur(t, itter - 1, level)
                if r:
                    return r
        return None

    return recur(grid, size * size * size, level)


# Sample random grids:
print('Example values :::: ((4,6,0), (5,2,3), (1,7,8))')
print('Example values :::: ((8,0,5), (1,7,2), (6,4,3))')
print('Example values :::: ((10,5,1,3), (7,11,2,12), (13,9,8,4), (6,15,0,14))')
gr=input('Enter the initial state values in ()  seperated by commas and 1 line values in (), second line values in()..; 0 being the blank::: example ((8,0,5), (1,7,2), (6,4,3)): please remember that the goal state for this code is getting blanck at the last position and is fixed:::    ')
#gr = ((4,6,0), (5,2,3), (1,7,8))
#gr = ((8,0,5), (1,7,2), (6,4,3))
#gr = ((10,5,1,3), (7,11,2,12), (13,9,8,4), (6,15,0,14))
#4,6,0,5,2,3,1,7,8

size = len(gr)
result_matrix = grid_matrix(size)

print 'printing results:'
result_value(gr)

for i in range(1, size * size - size + 1):
    banned_moves = get_banned_moves(gr, i - 1)
    counter, gr = bf_search(gr, i)
    #counter, gr = df_search(gr, i)
    print 'Moving ' + str(i) + ' into tile. In ' + str(counter) + ' moves'
    result_value(gr)
