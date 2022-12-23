# Rock Paper Scissor Game

Content
- [Rabobank task](#rabobank-task)
- [How to run](#how-to-run)
- [Documentation](#documentation)

## Rabobank Task

We kindly ask you to develop a Web application that can allow one
player to play the game of ROCK,Papers and Scissors.

### Technical Details
- Game description https://en.wikipedia.org/wiki/Rock_paper_scissors
- We prefer REST endpoint to play the game.
- The game to be played against the computer random hand.

### Think about
- Readability.
- Production readiness.
- Testing.
- Clean code.
- Scalability.
- Maintainability.
- Documentation.

### Nice to have
- To have Frontend that enable playing the game on web.

## How to run
Two options:

- Just Run `RockPaperScissorApplication.kt`

- With docker:
  - build image running: `docker build -t rps-back . `
  - once build run: `docker run -p 8080:8080 rps-back:latest`

## Documentation

Program done following DDD and Clean Architecture, structured in 3 layers:
- config: joins everything applying dependency injection
- core: has the business logic, doesn't know the other layers
- delivery: handles communication with the outside
- there is no infrastructure layer since it wasn't needed

### How to use

#### To play against the computer:

Hit endpoint localhost:8080/computer/play-hand with a POST and body:
``` JSON
{
"hand_shape": "rock"
}
```
Available hand shapes are: `rock, paper, scissor`

Response contains where you win, draw or lose and the hand played by the opponent