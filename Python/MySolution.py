#Name: Sai Manikanta S. Godavarthi
#WSU ID: J989E647
#AI programming Assignment - I
#Title: Eight Puzzle Problem

import Queue
print('Example values ::: [0,1,2,3,4,5,6,7,8]')
print('Example values:::: [1,2,3,4,5,6,7,8,0]')
goal_state=input('Enter the goal state values in []  seperated by commas; 0 being the blank; Examples are given as above:::')

#Example values::[0,1,2,3,4,5,6,7,8] #This is our goal state
practice_state=[1,2,0,3,4,5,6,7,8]
print('Example values ::: [1,2,3,4,5,6,7,0,8]')
print('Example values ::: [1,2,3,0,4,5,6,7,8]')
print('Example values ::: [1,2,0,3,4,5,6,7,8]')
print('Example values ::: [4,5,6,7,8,2,3,1,0]')
print('Example values ::: [1,2,3,4,5,0,6,7,8]')
print('Example values ::: [1,2,3,4,5,6,7,8,0]')
initial_state=input('Enter the intial state values in []  seperated by commas; 0 being the blank; Examples are given as above:::')
#Examples below
#initial_state=[1,2,3,4,5,6,7,0,8] # This is our Initial state
#initial_state=[1,2,3,0,4,5,6,7,8] # This is our Initial state
#initial_state=[1,2,0,3,4,5,6,7,8] # This is our Initial state
#initial_state=[4,5,6,7,8,2,3,1,0] # This is our Initial state
#initial_state=[1,2,3,4,5,0,6,7,8] # This is our Initial state
#initial_state=[1,2,3,4,5,6,7,8,0] # This is our Initial state


actions=['up','down','left','right'] #Moves performed during reaching goal state

class AiAssignment(object):
    def __init__(self,initial_state,goal_state=None):
        self.initial_state=initial_state
        self.goal_state=goal_state
    def actions(self,state):
        possible_actions=[]
        location=state.index(0)
        if(location>2): 
            possible_actions.append("up")
        if(location<6): 
            possible_actions.append("down")
        if(location%3!=0): 
            possible_actions.append("left")
        if location%3!=2: 
            possible_actions.append("right")
        return possible_actions
    def result(self,state,action):
        
        location=state.index(0)
        if action=="up": 
            new_location=location-3
        elif action=="down": 
            new_location=location+3
        elif action=="left": 
            new_location=location-1
        elif action=="right": 
            new_location=location+1
        state[new_location],state[location]=state[location],state[new_location]
        return state
    def verify_goal(self,state):
        
        return state==self.goal_state
class Node(object):
    def __init__(self,state,parent=None,action="None",path_cost=0,depth=0):
        self.state=state
        self.parent=parent
        self.action=action
        self.path_cost=path_cost
        self.depth=depth
    def expand(self,AiAssignment):
        
        return [self.child_node_value(AiAssignment,action) for action in AiAssignment.actions(self.state)]
    def child_node_value(self,AiAssignment,action):
        
        return Node(AiAssignment.result(self.state[:],action),self,action, self.path_cost+1,self.depth+1)
    def solution(self):
        
        return [node.action for node in self.path()[1:]]
    def prob_solution(self):
        
        prob_solution=""
        for node in self.path()[:]:
            prob_solution+="Step "+str(node.depth)+" : "+node.action+"\n"+node.pretty_state()+"\n"
        return prob_solution
    def path(self):
        
        node,path_back=self,[]
        while node:
            path_back.append(node)
            node=node.parent
        return list(reversed(path_back))
    def pretty_state(self):
        
        pretty_state=""
        for i in [0,3,6]:
            pretty_state+=str(self.state[i])+' '+str(self.state[i+1])+' '+str(self.state[i+2])+'\n'
        return pretty_state
    def __eq__(self,other):
       
        return isinstance(other,Node) and self.state==other.state
    def __hash__(self):
        return hash(self.state)
def Cost2Go(state,goal_state):
    
    n=0
    for i in range(len(state)):
        if state[i]!=goal_state[i]:
            n+=1
    return n
def priority_queue(node,goal_state):
    return node.path_cost+Cost2Go(node.state,goal_state)
def iterative_astar_search(node,AiAssignment):
    
    frontier=Queue.PriorityQueue()
    explored=[]
    frontier.put((priority_queue(node,AiAssignment.goal_state),node))
    while not frontier.empty(): 
        node=frontier.get()[1]
        if AiAssignment.verify_goal(node.state): 
            return node.prob_solution()
        explored.append(node.state)
        for action in AiAssignment.actions(node.state):
            new_node=node.child_node_value(AiAssignment,action)
            """
            if the case like new node hasn't been explored yet then add it to the frontier.
            otherwise, if it's already in explored state then it had to be at least as good priority queue value because path cost has to have been at least as little as possible and cost to go is the same value
            """
            if new_node.state not in explored:
                frontier.put((priority_queue(new_node,AiAssignment.goal_state),new_node))
    return "No solution has been found"

print iterative_astar_search(Node(initial_state),AiAssignment(initial_state,goal_state))
