import beerapp.BeerCompany
import beerapp.Beer
import beerapp.UserRole
import beerapp.User
import beerapp.Role

class BootStrap {

    def springSecurityService

    def init = { servletContext ->
        log.info("startup")

        if(!BeerCompany.list()) {
            BeerCompany phillips = new BeerCompany(name: 'Phillips', hops: 800000)
            phillips.save()
            log.info("BeerCompany created: ${phillips.id}")

            BeerCompany lighthouse = new BeerCompany(name: 'Lighthouse', hops: 500000)
            lighthouse.save()
            log.info("BeerCompany created: ${lighthouse.id}")

            def beers = [
                new Beer(name: 'Blue Buck', alcoholVolume: 5.0, description: 'good', company: phillips),
                new Beer(name: 'Hop Circle IPA', alcoholVolume: 6.5, description: 'hoppy', company: phillips),
                new Beer(name: 'Beacon IPA', alcoholVolume: 6.0, description: 'hoppy', company: lighthouse)
            ]

            beers.each {
                it.save()
                if(it.hasErrors()) {
                    log.error(it.errors.allErrors*.toString())
                }
                log.info("${it.id}, ${it.name}, ${it.company.name}")
            }

            // id lookup
            BeerCompany justAdded = BeerCompany.get(phillips.id)
            log.info("BeerCompany lookup of ${phillips.id}: ${justAdded.name}")

            // dynamic criteria
            beers = Beer.findAllByCompany(justAdded)
            log.info("Beers found: ${beers*.name}")

            beers = Beer.findAllByAlcoholVolumeGreaterThan(5.1f)
            log.info("Beers found: ${beers*.name}")

            // criteria based
            beers = Beer.withCriteria {
                between('alcoholVolume', 6.0f, 6.5f)
                eq('description', 'hoppy')
                order("name", "asc")
            }
            log.info("Beers found: ${beers*.name}")


            Role role = Role.findByAuthority('ROLE_USER')
            if(!role) {
                role = new Role(authority: 'ROLE_USER')
                role.save()
            }

            User user = User.findByUsername('csmith')
            if(!user) {
                user = new User(username: 'csmith',
                        password: springSecurityService.encodePassword('pass', 'csmith'),
                        enabled: true)
                user.save()
            }

            UserRole userRole = UserRole.findByUserAndRole(user, role)
            if(!userRole) {
                userRole = new UserRole(user: user, role: role)
                userRole.save()
            }

        }
    }
    
    def destroy = {
    }
}
