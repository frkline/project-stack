name 'development'
description 'development with vagrant'
override_attributes ({
    'stack' => {
        'app' => {
            'dir' => '/host/source/stack-app/app/'
        }
    }
})