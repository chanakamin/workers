# workers

## Table of Contents

- [About](#about)
- [Usage](#usage)
- [Routes](#routes)
- [Next Steps](#next)

## About <a name = "about"></a>

Test Project - Backend Side
Includes abilities to create, get and delete units,
And create / delete / fetch / update all workers of units.

### Installing

Make sure you have mysql installed, and a DB exists.
Download this package,
Update correct db settings in `application.settings` file
and then run:

```
./gradlew bootRun
```


## Usage <a name = "usage"></a>
Server Base URI on development mode:  <b>http://localhost:8080</b>
Project has 2 controllers:
- Unit
- Worker
### Unit Routes
#### Get all units  

```http
  GET /unit
```
Response: Units list

#### Get unit

```http
  GET /unit/:id
```

Response: Unit

#### Delete unit

```http
  Delete /unit/:id
```

#### Create unit

```http
  Post /unit/:id
```
| Parameter             |  Description                  |
| :----------------     |  :-------------------------   |
| `name`                |  unit name |
| `managerName`          | unit manager name |

Response: Unit

### Worker Routes
#### Get all workers  

```http
  GET /unit/:unitId/worker
```
Response: Workers list

#### Get worker

```http
  GET /unit/:unitId/worker/:workerId
```

Response: Worker

#### Delete worker

```http
  Delete /unit/:unitId/worker/:workerId
```

#### Create Worker

```http
  Post /unit/:unitId/worker
```
| Parameter             |  Description                  |
| :----------------     |  :-------------------------   |
| `firstName`                |  worker first name |
| `lastName`          | worker last name |
| `workerNumber`                | unique idetify number for worker  |
| `birthDate`          | worker birthday |
| `startWorkAt`          | date the worker start to work |

Response: Worker

## Next Steps <a name = "next"></a>
- Add Swagger
- Add Logger
- Validation Inputs
- Exceptions management
- Unit tests


